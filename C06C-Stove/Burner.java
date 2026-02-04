public class Burner {
    public enum Temperature{
        COLD, WARM, HOT, BLAZING;

        //Next function to get the next value in enum
        public Temperature next() {
        if (this.ordinal() == values().length - 1) {
            return this;
        }
        return values()[this.ordinal() + 1];
        }
    }
    
    private Temperature myTemperature;
    private Setting mySetting;
    private int timer;
    final static int TIME_DURATION = 2;

    //Constructor to set burner temp and stove setting
    public Burner(){
        myTemperature = Temperature.COLD;
        mySetting = Setting.OFF;
    }

    //Getter to get temperature
    public Temperature getTemperature(){
        return myTemperature;
    }

    //Increase setting by 1 and checks if it cannot be increased further
    public void plusButton(){
        timer = TIME_DURATION;
        switch(mySetting){
            case OFF:
                mySetting = Setting.LOW;
                break;
            case LOW:
                mySetting = Setting.MEDIUM;
                break;
            case MEDIUM:
                mySetting = Setting.HIGH;
                break;
            default:
                break;
            
        }  
    }

    //Decrease setting by 1 and checks if it cannot be decreased further
    public void minusButton(){
        timer = TIME_DURATION;
        switch(mySetting){
            case HIGH:
                mySetting = Setting.MEDIUM;
                break;
            case MEDIUM:
                mySetting = Setting.LOW;
                break;
            case LOW:
                mySetting = Setting.OFF;
                break;
            default:
                break;
        }
    }

    //Checks if Temperature enum index is still less than setting, to determine if temperature can still rise.
    public void updateTemperature(){
        if(timer == 0){
            if(myTemperature.ordinal() < mySetting.ordinal()-1){
                myTemperature = myTemperature.next();
                timer = TIME_DURATION;
            }else if(myTemperature.ordinal() == mySetting.ordinal()-1){
                myTemperature = myTemperature.next();
                timer = 0;
            }
        }else{
            timer-=1;
        }
    }

    //Display current stove intensity 
    public void display(){
        String stoveIntensity = mySetting.toString();
        switch(mySetting){
            case OFF:
                System.out.println(stoveIntensity+""+".....cooool");
                break;
            case LOW:
                System.out.println(stoveIntensity+""+".....warm");
                break;
            case MEDIUM:
                System.out.println(stoveIntensity+""+".....CAREFUL");
                break;
            case HIGH:
                System.out.println(stoveIntensity+""+".....VERY HOT! DON'T TOUCH");
            default:
                break;
        }
    }
}
