
import spock.lang.*

class ScorePrinterSpec extends Specification {
    def "打率数を計算しない場合、「---」と出力すること"() {
        setup:
        def scorePrinter = new ScorePrinter()

        expect:
        scorePrinter.format(null) == "----"
    }

    def "打率が10割の場合は、「1.00」と出力すること"() {
        setup:
        def scorePrinter = new ScorePrinter()

        expect:
        scorePrinter.format(battingAverage) == "1.00"

        where:
        battingAverage << [1, 1.00, 1.0000]
    }
}
