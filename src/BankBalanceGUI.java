import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField amountField;
    private JLabel balanceLabel;
    private BankAccount account;

    public BankBalanceGUI() {
        account = new BankAccount(0.0); // Initial balance

        frame = new JFrame("Bank Balance Application");
        panel = new JPanel();

        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);

        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton balanceButton = new JButton("Show Balance");

        balanceLabel = new JLabel("Balance: $0.00");

        depositButton.addActionListener(new ButtonClickListener());
        withdrawButton.addActionListener(new ButtonClickListener());
        balanceButton.addActionListener(new ButtonClickListener());

        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(balanceButton);
        panel.add(balanceLabel);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            double amount = Double.parseDouble(amountField.getText());

            if (command.equals("Deposit")) {
                account.deposit(amount);
            } else if (command.equals("Withdraw")) {
                account.withdraw(amount);
            }

            balanceLabel.setText(String.format("Balance: $%.2f", account.getBalance()));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankBalanceGUI::new);
    }
}
