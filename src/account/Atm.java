package account;

import java.util.Scanner;

public class Atm {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bank myBank = new Bank("First Bank");

        String choice = "";
        while(!choice.equals("0")) {
            String menu = """
                    
                    ===== WELCOME TO ATM =====
                    1. Create Account
                    2. Check Balance
                    3. Deposit
                    4. Withdraw
                    5. Transfer
                    0. Exit
                    ==========================
                    """;

            System.out.println(menu);
            System.out.print("Enter Choice: ");
            choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("CREATE ACCOUNT");
                    System.out.print("Enter your Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter you Pin: ");
                    String pin = input.nextLine();

                    try {
                        Account account = myBank.createAccount(name, pin);
                        System.out.println("Your Account has successfully been created!");
                        System.out.println("Your Account Number is " + account.getAccountNumber());
                    }
                    catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "2":
                    System.out.println("CHECK BALANCE");
                    System.out.print("Enter Account Number: ");
                    int accountNumber = input.nextInt();

                    input.nextLine();

                    System.out.print("Enter Pin: ");
                    String PIN = input.nextLine();

                    try {
                        System.out.println("Your Balance is " + myBank.checkBalance(accountNumber, PIN));
                    } catch (Exception e) {
                        System.out.println("Error! Wrong Account number or PIN. Please try again");
                    }
                    break;

                case "3":
                    System.out.println("DEPOSIT");
                    System.out.print("Enter Account Number: ");
                    int accountNum = input.nextInt();

                    System.out.print("Enter Amount: ");
                    int amount = input.nextInt();

                    input.nextLine();

                    try {
                        myBank.deposit(accountNum, amount);
                        System.out.println("You have successfully deposited " + amount);
                    } catch (Exception e) {
                        System.out.println("Error! Wrong Account number or Amount. Please try again");
                    }
                    break;

                case "4":
                    System.out.println("WITHDRAW");
                    System.out.print("Enter Account Number: ");
                    int accountNumb = input.nextInt();

                    input.nextLine();

                    System.out.print("Enter Pin: ");
                    String Pin = input.nextLine();

                    System.out.print("Enter Amount: ");
                    int amounts = input.nextInt();

                    input.nextLine();

                    try {
                        myBank.withdraw(accountNumb, Pin, amounts);
                        System.out.println("You have successfully withdrawn " + amounts);
                    } catch (Exception e) {
                        System.out.println("Error! Wrong Account number or Pin. Please try again");
                    }
                    break;

                case "5":
                    System.out.println("TRANSFER");
                    System.out.print("Enter your Account Number: ");
                    int senderAccountNumber = input.nextInt();

                    input.nextLine();

                    System.out.print("Enter your Pin: ");
                    String pins = input.nextLine();

                    System.out.print("Enter Recipient's Account Number: ");
                    int receiverAccountNumber = input.nextInt();

                    System.out.print("Enter Amount: ");
                    int transferAmount = input.nextInt();

                    input.nextLine();

                    try {
                        Account myAccount = myBank.findAccount(receiverAccountNumber);

                        myBank.transfer(senderAccountNumber, pins, receiverAccountNumber, transferAmount);
                        System.out.println("You have successfully transfered " + transferAmount + " to " + myAccount.getAccountName() + "'s account.");
                    } catch (Exception e) {
                        System.out.println("Check your details very well and try again");
                    }
                    break;

                case "0":
                    System.out.println("Thank you for using our account");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            
        }

    }

}
