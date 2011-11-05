import spock.lang.*

class PlayerSpec extends Specification {

  def "打席数と打数と案段数を受け取り、打率を計算する"() {
    setup:
    def player = new Player(box:box, atBat:atBat, hit:hit)

    expect:
    player.getBattingAverage() == battingAverage

    where:
    box | atBat | hit | battingAverage
    3   | 2     | 1   | 0.5
    4   | 4     | 1   | 0.25
  }

  def "打席数と打数と案段数を受け取り、小数第四位で四捨五入する (無限小数、切り捨て)"() {
    setup:
    def player = new Player(box:3, atBat:3, hit:1)

    expect:
    player.getBattingAverage() == 0.333

  }

  def "打席数と打数と案段数を受け取り、小数第四位で四捨五入する (切り上げ)"() {
    setup:
    def player = new Player(box:515, atBat:455, hit:135)

    expect:
    player.getBattingAverage() == 0.297
  }
}
