import spock.lang.*

class PlayerSpec extends Specification {

  def "打席数と打数と安打数を受け取り、打率を計算する"() {
    setup:
    def player = new Player(box:box, atBat:atBat, hit:hit)

    expect:
    player.battingAverage == battingAverage

    where:
    box | atBat | hit | battingAverage
    3   | 2     | 1   | 0.5
    4   | 4     | 1   | 0.25
  }

  def "打席数と打数と安打数を受け取り、小数第四位で四捨五入する (無限小数、四捨)"() {
    setup:
    def player = new Player(box:3, atBat:3, hit:1)

    expect:
    player.battingAverage == 0.333

  }

  def "打席数と打数と安打数を受け取り、小数第四位で四捨五入する (五入)"() {
    setup:
    def player = new Player(box:515, atBat:455, hit:135)

    expect:
    player.battingAverage == 0.297
  }

  def "打席数が0の場合は、打率を計算せずにnullを返す"() {
    setup:
    def player = new Player(box:0, atBat:455, hit:135)

    expect:
    player.battingAverage == null
  }

  def "打数が0の場合は、0.000を返す"() {
    setup:
    def player = new Player(box:3, atBat:0, hit:0)

    expect:
    player.battingAverage.class == BigDecimal.class
    player.battingAverage.scale() == 3
    player.battingAverage == 0.000
  }

}
