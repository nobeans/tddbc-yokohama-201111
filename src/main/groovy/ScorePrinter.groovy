class ScorePrinter{
    def format(battingAverage) {
        if (battingAverage == null) {
            return "----"
        }
        if (battingAverage >= 1) {
            return "1.00"
        }
        return battingAverage.toString().replaceFirst(/^0/, '')
    }
}
