public class Burner {
    public enum Temperature{
        COLD, WARM, HOT, BLAZING;

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

    public Burner(){
        myTemperature = Temperature.COLD;
        mySetting = Setting.OFF;
    }

    public Temperature getTemperature(){
        return myTemperature;
    }

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

    public void display(){
        String stoveIntensity = mySetting.toString();
        switch(mySetting){
            case OFF:
                System.out.println(stoveIntensity+""+".....cooool");
            case LOW:
                System.out.println(stoveIntensity+""+".....warm");
            case MEDIUM:
                System.out.println(stoveIntensity+""+".....CAREFUL");
            case HIGH:
                System.out.println(stoveIntensity+""+".....VERY HOT! DON'T TOUCH");
            default:
                break;
        }
    }
}
