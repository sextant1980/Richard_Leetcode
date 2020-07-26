public class Developer extends Employee {

    private double raise_amount = 1.10;
    private String prog_lang;

    public Developer(String first, String last, int pay, String prog_lang){
        super(first, last, pay);
        this.prog_lang = prog_lang;
    }

    public String getProg_lang() {
        return prog_lang;
    }

    public void setProg_lang(String prog_lang) {
        this.prog_lang = prog_lang;
    }

    @Override
    public double getRaise_amount() {
        return raise_amount;
    }

    @Override
    public void setRaise_amount(double raise_amount) {
        this.raise_amount = raise_amount;
    }

    @Override
    public void apply_raise(){
        this.setPay((int) (this.getPay() * raise_amount));;
    }
}
