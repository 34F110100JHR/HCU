package ATM;

public class Account {
    private String name;
    private String cardId;
    private String passWord;
    private double money;
    private double moneyLimit;

    public Account() {
    }

    public Account(String name, String cardId, String passWord,double moneyLimit) {
        this.name = name;
        this.cardId = cardId;
        this.passWord = passWord;
        this.money = money;
        this.moneyLimit = moneyLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardID() {
        return cardId;
    }

    public void setCardID(String cardID) {
        this.cardId = cardID;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoneyLimit() {
        return moneyLimit;
    }

    public void setMoneyLimit(double moneyLimit) {
        this.moneyLimit = moneyLimit;
    }
}
