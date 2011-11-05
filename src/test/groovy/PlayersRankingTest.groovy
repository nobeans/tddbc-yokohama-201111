
import spock.lang.*

class PlayerRankingSpec extends Specification {

    def "Groovyではコレクション操作が簡単なのでホストクラス側で実装しなくても良いよね"() {
        setup:
        def player1 = new Player(box:3, atBat:3, hit:3)
        def player2 = new Player(box:3, atBat:3, hit:2)
        def player3 = new Player(box:3, atBat:3, hit:1)
        def player4 = new Player(box:3, atBat:3, hit:0)
        def player5 = new Player(box:0, atBat:0, hit:0)

        def players = [
            player2, player1, player4, player5, player3
        ]

        expect:
        players.sort{ it.battingAverage }.reverse() == [player1, player2, player3, player4, player5]
    }
}
