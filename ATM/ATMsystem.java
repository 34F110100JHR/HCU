package ATM;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATMsystem {
    public static void main(String[] args) {
        //1.准备系统需要的容器对象，用于存储账户对象  -> arraylist
        ArrayList<Account> accounts = new ArrayList<>();

        showMain(accounts);

    }

    //2.准备系统首页：开户、登录  -> scanner while switch
    public static String showMain(ArrayList<Account> accounts) {
        System.out.println("=================欢迎进入首页===================");

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1、登录");
            System.out.println("2、开户");
            System.out.print("请输入命令：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    //登录
                    login(accounts, sc);
                    break;
                case 2:
                    //开户
                    register(accounts, sc);
                    break;
                default:
                    System.out.println("您输入的指令不存在！");
            }
        }
    }

    /**
     * 完成用户登录
     *
     * @param accounts
     */
    private static void login(ArrayList<Account> accounts, Scanner sc) {
        //让用户键盘录入卡号，根据卡号查询用户对象
        if (accounts.size() == 0) {
            System.out.println("当前系统中无任何账户，请先注册！");
            return;
        }
        while (true) {
            System.out.println("请您输入卡号：");
            String cardId = sc.next();
            Account acc = getAccountByCardId(accounts, cardId);
            if (acc != null) {
                while (true) {
                    System.out.println("请你输入密码：");
                    String password = sc.next();
                    if (acc.getPassWord().equals(password)) {
                        System.out.println("恭喜您" + acc.getName() + "先生/女士成功进入系统,您的卡号是" + acc.getCardID());
                        //查询账户 存款 取款 转账 修改密码 退出 注销账户
                        showUserCommand(sc, acc, accounts);
                        return;
                    } else {
                        System.out.println("密码错误！请重新输入!");
                    }
                }
            } else {
                System.out.println("您输入的卡号不存在！");
            }
        }
    }

    private static void showUserCommand(Scanner sc, Account acc, ArrayList<Account> accounts) {
        while (true) {
            System.out.println("=================操作界面===================");

            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出");
            System.out.println("7.注销账户");
            System.out.println("请你输入指令：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    showAccount(acc);
                    //查询账户
                    break;
                case 2:
                    //存款
                    depositMoney(acc, sc);
                    break;
                case 3:
                    //取款
                    drawMoney(acc, sc);
                    break;
                case 4:
                    //转账
                    transferMoney(acc, sc, accounts);
                    break;
                case 5:
                    //修改密码
                    changePassword(acc, sc, accounts);
                    return;
                case 6:
                    //退出
                    System.out.println("欢迎下次光临！");
                    return;
                case 7:
                    //注销账户
                    accounts.remove(acc);
                    System.out.println("您已经销户成功");
                    return;
                default:
                    System.out.println("您输入的指令有误！");
            }
        }
    }

    private static void changePassword(Account acc, Scanner sc, ArrayList<Account> accounts) {
        while (true) {
            System.out.println("请您确认旧密码：");
            String password = sc.next();
            if (password.equals(acc.getPassWord())) {
                if (password.equals(acc.getPassWord())) {
                    System.out.println("请输入新密码：");
                    String newPassword = sc.next();
                    System.out.println("请确认新密码：");
                    String newPasswordAgain = sc.next();
                    if (newPassword.equals(newPasswordAgain)) {
                        acc.setPassWord(newPassword);
                        System.out.println("恭喜您修改密码成功！");
                        return;
                    } else {
                        System.out.println("两次密码不一致，请重新输入！");
//                       return;
                    }
                } else {
                    System.out.println("您输入的密码错误，请重新输入");
//                   return;
                }
            } else {
                System.out.println("您输入的密码不对，请重新输入！");
            }
        }
    }

    private static void transferMoney(Account acc, Scanner sc, ArrayList<Account> accounts) {
        while (true) {
            System.out.println("=================转账操作===================");
            //1,判断系统中是否有2个账户以上
            if (accounts.size() < 2) {
                System.out.println("当前系统无其他账户，无法转账！");
                return;
            }
            //2，判断自己的账户中是否有钱
            if (acc.getMoney() == 0) {
                System.out.println("当前您的账户余额为零，无法转账！");
                return;
            }
            //3，开始转账逻辑
            //3.1 输入对方账号
            System.out.println("请输入转账方的卡号：");
            String cardId = sc.next();
            Account account = getAccountByCardId(accounts, cardId);
            //3.2 判断对方账户是否存在，存在说明卡号输入正确
            if (account != null) {
                if (account.getCardID().equals(acc.getCardID())) {
                    System.out.println("不能给自己转账！");
                } else {
                    String name = "*" + account.getName().substring(1);
                    System.out.println("请你验证" + name + "的姓氏");
                    String firstName = sc.next();
                    if (account.getName().startsWith(firstName)) {
                        System.out.println("请你输入转账金额：");
                        double money = sc.nextDouble();
                        if (acc.getMoney() < money) {
                            System.out.println("您的余额不足，无法转账当前数目，您可以转账的金额为" + acc.getMoney());
                        } else {
                            account.setMoney(account.getMoney() + money);
                            acc.setMoney(acc.getMoney() - money);
                            System.out.println("恭喜您转账成功，您已为" + account.getName() + "转入" + money + "元");
                            System.out.println("您的余额还有" + acc.getMoney() + "元");
                            showAccount(acc);
                            return;
                        }
                    } else {
                        System.out.println("您输入的姓氏验证有误！请重新输入！");
                    }
                }
            } else {
                System.out.println("对方账户不存在，请重新输入！");
            }
        }
        //3.3 判断这个账号是不是自己


    }

    private static void drawMoney(Account acc, Scanner sc) {
        while (true) {
            System.out.println("=================取款操作===================");
            if (acc.getMoney() >= 100) {
                System.out.println("请输入取款金额：");
                double money = sc.nextDouble();
                if (money > acc.getMoneyLimit()) {
                    System.out.println("取款金额超过限额，请重新输入！");
                } else {
                    if (acc.getMoney() >= money) {
                        acc.setMoney(acc.getMoney() - money);
                        System.out.println("恭喜您取款" + money + "成功" + ",当前余额为" + acc.getMoney());
                        return;
                    } else {
                        System.out.println("取款金额超过余额，请重新输入！");
                    }
                }
            } else {
                System.out.println("余额小于100，不能取款！");
                return;
            }
        }
    }

    private static void depositMoney(Account acc, Scanner sc) {
        System.out.println("=================存款操作===================");
        System.out.println("请输入存款金额：");
        double money = sc.nextDouble();
        acc.setMoney(acc.getMoney() + money);
        System.out.println("存款成功！");
        showAccount(acc);
    }

    private static void showAccount(Account acc) {
        System.out.println("=================账户详情===================");
        System.out.println("用户名：" + acc.getName());
        System.out.println("卡号：" + acc.getCardID());
        System.out.println("余额：" + acc.getMoney());
        System.out.println("限额：" + acc.getMoneyLimit());

    }

    /**
     * 用户开户功能
     *
     * @param accounts
     * @param sc
     */
    private static void register(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("=================开户界面===================");

        System.out.println("请输入用户名：");
        String name = sc.next();
        String password = "";
        while (true) {
            System.out.println("请输入密码：");
            password = sc.next();
            System.out.println("请确认密码：");
            String okPassword = sc.next();
            if (okPassword.equals(password)) {
                break;
            } else {
                System.out.println("两次密码不一致！");
            }
        }
        System.out.println("输入限额：");
        double moneyLimit = sc.nextDouble();
        String cardId = createCardId(accounts);

        Account account = new Account(name, cardId, password, moneyLimit);
        accounts.add(account);
        System.out.println("恭喜您开户成功，您的卡号是" + account.getCardID());
    }

    //生成账户的卡号，卡号8位，卡号不能重复
    public static String createCardId(ArrayList<Account> accounts) {
        while (true) {
            Random r = new Random();
            String cardId = "";
            for (int i = 0; i < 8; i++) {
                cardId += r.nextInt(10);
            }
            Account acc = getAccountByCardId(accounts, cardId);
            if (acc == null) {
                return cardId;
            }
        }
    }
    public static Account getAccountByCardId(ArrayList<Account> accounts, String cardId) {
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getCardID().equals(cardId)) {
                return acc;
            }
        }
        return null;
    }
}
