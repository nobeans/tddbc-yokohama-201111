class ScorePrinter{
    def format(battingAverage) {
        if (battingAverage == null) {
            return "----"
        }else if (battingAverage  < 1.00 ){
           return battingAverage.toString().replaceFirst(/^0/, '')
        }else{
          return "1.00"
        }
    }
}
