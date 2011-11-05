import spock.lang.*

class PlayerSpec extends Specification {

  def "打席数と打数と案段数を受け取り、打率を計算する"() {
    setup:
    def player = new Player(box:3, atBat:2, hit:1)

    expect:
    player.getBattingAverage() == 0.5
  }

  def "打席数と打数と案段数を受け取り、打率を計算する 2"() {
    setup:
    def player = new Player(box:4, atBat:4, hit:1)

    expect:
    assert player.getBattingAverage() == 0.25
  }

  //def "打席数と打数と案段数を受け取り、小数第四位で四捨五入する"() {
}
