
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

    def "打率が10割未満の場合は、先頭の0を省略して「.333」のように出力すること"() {
        setup:
        def scorePrinter = new ScorePrinter()

        expect:
        scorePrinter.format(battingAverage) == result

        where:
        battingAverage | result
        0.000          | ".000"
        0.001          | ".001"
        0.333          | ".333"
        0.999          | ".999"
        0.9999999      | ".9999999"
    }
}
