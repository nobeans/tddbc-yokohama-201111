import java.math.*

class Player {
    int box
    int atBat
    int hit

    def getBattingAverage() {
	if( this.box == 0 ) {
	 	return null
	}
	if ( this.atBat == 0 ){
		return 0.000
	}
        (hit as BigDecimal).divide(atBat, 3, RoundingMode.HALF_UP)
    }
}
