public enum Setting {
    OFF("---"), LOW("--+"), MEDIUM("-++"),HIGH("+++");
    
    private final String intensity;

    private Setting(String intensity){
        this.intensity = intensity;
    }
    @Override
    public String toString(){
        return intensity;
    }
}
