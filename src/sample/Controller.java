package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;



import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // Declararea variabilelor programului:
        @FXML
        private Button btnBalance;

        @FXML
        private Button btnWithdraw;

        @FXML
        private Button btnLoan2;

        @FXML
        private Button btnDeposit;

        @FXML
        private Button btnLoan;

        @FXML
        private Button btnReset;

        @FXML
        private Button btnReceipt;

        @FXML
        private Button btnExit;

        @FXML
        private Button btn1;

        @FXML
        private Button btn2;

        @FXML
        private Button btn3;

        @FXML
        private Button btn4;

        @FXML
        private Button btn5;

        @FXML
        private Button btn6;

        @FXML
        private Button btn7;

        @FXML
        private Button btn8;

        @FXML
        private Button btn9;

        @FXML
        private Button btnCancel;

        @FXML
        private Button btnClear;

        @FXML
        private Button btnEnter;

         @FXML
         private TextField txtInterest;

        @FXML
         private TextField txtYears;

        @FXML
        private TextField txtLoan;

        @FXML
        private Label txtMPayment;

        @FXML
        private Label txtTPayment;

        @FXML
        private TextArea txtReceipt;

        @FXML
        private TextArea txtDisplay;

        @FXML
        private Label lblDisplay;

        @FXML
        private Button btn0;

        @FXML
        private Label lblLoan;

        @FXML
        private Label lblDeposit;

        @FXML
        private Label lblBalance;

        @FXML
        private Label lblWithdraw;

        // Butonul de EXIT se programeaza asa:

        @FXML
        void display(ActionEvent event) {
            btnExit.setOnMouseClicked(e -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Esti sigur?");

                ButtonType userOption = alert.showAndWait().get();
                if(userOption == ButtonType.CANCEL) {
                    System.out.println("Utilizatorul a anulat iesirea!");

                }
                if(userOption == ButtonType.OK) {
                    System.out.println("Utilizatorul tocmai ce a iesit!");

                }
               System.exit(0);

            });
        }

        // Pentru butonul btnLoan2, avem urmatoarea rezolvare:
        @FXML
        void rezolvamButoane (ActionEvent e) {
            btnExit.setDisable(false);
            btnLoan.setDisable(false);
            btnReceipt.setDisable(false);
            btnReset.setDisable(false);


        }

        // pentru Ecranul aplicatiei, avem urmatoarea rezolvare:
        @FXML
        void window (MouseEvent e) {
            btnExit.setDisable(true);
            btnLoan.setDisable(true);
            btnReceipt.setDisable(true);
            btnReset.setDisable(true);
            btnBalance.setDisable(true);
            btnWithdraw.setDisable(true);
            btnDeposit.setDisable(true);
            btnLoan2.setDisable(true);

            lblLoan.setVisible(true);
            lblWithdraw.setVisible(true);
            lblDeposit.setVisible(true);
            lblBalance.setVisible(true);
        }

        // Pentru butonul de Receipt, avem urmatoarea rezolvare:
        @FXML
        void btnReceipt (ActionEvent e) {
            btnReceipt.setOnMouseClicked(event -> {
                String annualInterestRate = String.format(txtInterest.getText());
                String numberOfYears = String.format(txtYears.getText());
                String loanAmount = String.format(txtLoan.getText());

                String monthlyPayment = String.format(txtMPayment.getText());
                String totalPayment = String.format(txtTPayment.getText());

                // =========================================================

                int refs = 1325 + (int) (Math.random()*4238);

                // =========================================================

                Calendar timer = Calendar.getInstance();
                timer.getTime();
                SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
                tTime.format(timer.getTime());
                SimpleDateFormat Tdate = new SimpleDateFormat("dd-MM-yyyy");
                Tdate.format(timer.getTime());

                // =========================================================

                txtReceipt.appendText("\tLoan Management Systems \n" +
                        "Reference : \t\t\t " + refs +
                        "\n=============================================================\t " +
                        "\nInterest rate: \t\t\t " + annualInterestRate +
                        "\nRepayment years: \t\t " + numberOfYears +
                        "\nAmount of Loan: \t\t " + "RON  " + loanAmount +
                        "\nMonthly payment:\t\t " + monthlyPayment +
                        "\nTotal payment: \t\t " + totalPayment   +

                        "\n==============================================================\t " +
                        "\nDate: " + Tdate.format(timer.getTime()) +
                        "\t\tTime: " + tTime.format(timer.getTime() ) +
                        "\n\n\t\tMultumim! \n"   );

            });
        }

        // Pentru butonul de Reset, avem urmatoarea rezolvare:

        @FXML
        void btnReset (ActionEvent e) {
            btnReset.setOnAction(event -> {
                txtInterest.setText(null);
                txtYears.setText(null);
                txtLoan.setText(null);
                txtMPayment.setText(null);
                txtTPayment.setText(null);
                txtReceipt.setText(null);
                txtDisplay.setText(null);
            });
        }

        // Pentru butonul de Loan, avem urmatoarea rezolvare:

        @FXML
        void btnLoan (ActionEvent e){
            btnLoan.setOnAction(event ->{
              double annualInterestRate = Double.parseDouble(txtInterest.getText());
              double monthlyInterestRate = annualInterestRate / 1200;
              int numberOfYears = Integer.parseInt(txtYears.getText());
              double loanAmount = Double.parseDouble(txtLoan.getText());

              // --------------------------------------------------------------------
                double monthlyPayment = loanAmount * monthlyInterestRate / (1-1/Math.pow(1+monthlyInterestRate, numberOfYears * 12));
                String imonthlyPayment;
                imonthlyPayment = Double.toString(monthlyPayment);
                imonthlyPayment = String.format("RON  %.2f", monthlyPayment);
                txtMPayment.setText(imonthlyPayment);

                // --------------------------------------------------------------------

                double totalPayment = monthlyPayment * numberOfYears * 12;
                String itotalPayment;
                itotalPayment = String.format("RON   %.2f", totalPayment);
                txtTPayment.setText(itotalPayment);


            });
        }

        // Programam numerele PIN-ului:
            @FXML
            void btn1 (ActionEvent e) {
            btn1.setOnAction(event -> {
                String enterNumber = lblDisplay.getText() + "1";
                lblDisplay.setText(enterNumber);
            });
            }

            @FXML
             void btn2 (ActionEvent e) {
            btn2.setOnAction(event -> {
            String enterNumber = lblDisplay.getText() + "2";
            lblDisplay.setText(enterNumber);
             }); }

             @FXML
             void btn3 (ActionEvent e) {
            btn3.setOnAction(event -> {
            String enterNumber = lblDisplay.getText() + "3";
            lblDisplay.setText(enterNumber);
        }); }


             @FXML
             void btn4 (ActionEvent e) {
            btn4.setOnAction(event -> {
            String enterNumber = lblDisplay.getText() + "4";
            lblDisplay.setText(enterNumber);
        }); }

            @FXML
            void btn5 (ActionEvent e) {
             btn5.setOnAction(event -> {
            String enterNumber = lblDisplay.getText() + "5";
            lblDisplay.setText(enterNumber);
        }); }

            @FXML
            void btn6 (ActionEvent e) {
            btn6.setOnAction(event -> {
            String enterNumber = lblDisplay.getText() + "6";
            lblDisplay.setText(enterNumber);
        }); }


            @FXML
            void btn7 (ActionEvent e) {
            btn7.setOnAction(event -> {
            String enterNumber = lblDisplay.getText() + "7";
            lblDisplay.setText(enterNumber);
        }); }

            @FXML
            void btn8 (ActionEvent e) {
            btn8.setOnAction(event -> {
            String enterNumber = lblDisplay.getText() + "8";
            lblDisplay.setText(enterNumber);
        }); }

            @FXML
            void btn9 (ActionEvent e) {
            btn9.setOnAction(event -> {
            String enterNumber = lblDisplay.getText() + "9";
            lblDisplay.setText(enterNumber);
        }); }

            @FXML
            void btn0 (ActionEvent e) {
            btn0.setOnAction(event -> {
            String enterNumber = lblDisplay.getText() + "0";
            lblDisplay.setText(enterNumber);
        }); }

        // Facem cele 3 butoane: CLEAR, ENTER, CANCEL:

        @FXML
        void btnClear (ActionEvent e) {
            btnClear.setOnAction(event -> {
               lblDisplay.setText(" ");
               btnExit.setDisable(true);
               btnLoan.setDisable(true);
               btnReceipt.setDisable(true);
               btnReset.setDisable(true);
               btnBalance.setDisable(true);
               btnWithdraw.setDisable(true);
               btnDeposit.setDisable(true);
               btnLoan2.setDisable(true);
            });
        }

        @FXML
        void btnEnter (ActionEvent e) {
            btnEnter.setOnAction(event -> {
               int pin1 = Integer.parseInt(lblDisplay.getText());
               if (pin1 == 1234) {
                   btnBalance.setDisable(false);
                   btnWithdraw.setDisable(false);
                   btnDeposit.setDisable(false);
                   btnLoan2.setDisable(false);
               } else {
                   lblDisplay.setText("Pin respins! Nu merge!");
                   lblLoan.setVisible(true);
                   lblWithdraw.setVisible(true);
                   lblDeposit.setVisible(true);
                   lblBalance.setVisible(true);
               }
            });
        }

        @FXML
        void btnCancel (ActionEvent e) {
            btnCancel.setOnAction(event -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("Esti sigur?");

                ButtonType userOption = alert.showAndWait().get();
                if(userOption == ButtonType.CANCEL) {
                    System.out.println("Utilizatorul a anulat sesiunea!");

                }
                if(userOption == ButtonType.OK) {
                    System.out.println("Utilizatorul a introdus o parola incorecta / nu a introdus o parola" +
                            " si deci a ales sa inchida sesiunea!");

                }
                System.exit(0);

            });

        }

        @Override
    public void initialize(URL location, ResourceBundle resources) { }
}