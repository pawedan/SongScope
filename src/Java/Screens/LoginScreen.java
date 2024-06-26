package Java.Screens;

import Java.TextFields.TextField;
import Java.TextFields.PasswordField;
import Java.Database.DatabaseManager;


import javax.swing.UIManager;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.WindowConstants;
import javax.swing.GroupLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.validator.routines.EmailValidator;
import org.mindrot.jbcrypt.BCrypt;




public class LoginScreen extends JFrame {

    private JLabel appNameLabel;
    private TextField emailText;
    private JPanel imagePanel;
    private JButton loginBtn;
    private JLabel loginLabel;
    private JPanel loginPanel;
    private JPanel mainPanel;
    private PasswordField passwordText;
    private JButton signUpBtn;
    private ImageIcon icon;
    private JLabel iconLabel;
    private JButton forgotPasswordBtn;
    private JLabel incorrectPasswordLabel;
    private Connection connection;



    public LoginScreen() {
        // Set Look and Feel for Buttons
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
                    e.printStackTrace();
        }

        connection = DatabaseManager.getConnection();

        // Initialize Components
        initComponents();
    }

    private void initComponents() {
        // Main Frame Settings
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);


        // Main Panel Settings
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setBounds(0, 0, 1000, 600);



        // Image Panel Settings
        imagePanel = new JPanel();
        imagePanel.setBackground(new Color(21, 170, 180));
        imagePanel.setPreferredSize(new Dimension(500, 600));

        // Icon Settings
        icon = new ImageIcon("src/img/Icon.png");
        Image image = icon.getImage();
        Image newImg = image.getScaledInstance(200, 200,  Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        iconLabel = new JLabel(icon);
        
        // App Name Settings
        appNameLabel = new JLabel();
        appNameLabel.setFont(new Font("Showcard Gothic", 0, 24));
        appNameLabel.setForeground(new Color(255, 255, 255));
        appNameLabel.setText("SongScope");

        // Login Panel Settings
        loginPanel = new JPanel();
        loginPanel.setBackground(new Color(255, 255, 255));
        loginPanel.setPreferredSize(new Dimension(500, 600));

        // Login Label Settings
        loginLabel = new JLabel("Login");
        loginLabel.setBackground(new Color(0, 102, 102));
        loginLabel.setFont(new Font("Segoe UI", 1, 24));
        
        // Email Text Field Settings
        emailText = new TextField();
        emailText.setForeground(new Color(102, 102, 102));
        emailText.setLabelText("Email");
        
        
        // Password Text Field Settings
        passwordText = new PasswordField();
        passwordText.setForeground(new Color(102, 102, 102));
        passwordText.setLabelText("Password");
        passwordText.setShowAndHide(true);


        // Incorrect Password Label Settings
        incorrectPasswordLabel = new JLabel(" ");
        incorrectPasswordLabel.setFont(new Font("Segoe UI", 0, 14));
        incorrectPasswordLabel.setForeground(new Color(255, 0, 0));
        incorrectPasswordLabel.setHorizontalAlignment(JLabel.CENTER);




        // Forgot Password Button Settings
        forgotPasswordBtn = new JButton("Forgot Password?");
        forgotPasswordBtn.setRolloverEnabled(false);
        forgotPasswordBtn.setFocusPainted(false);
        forgotPasswordBtn.setContentAreaFilled(false);
        forgotPasswordBtn.setBorder(null);
        forgotPasswordBtn.setFont(new Font("Segoe UI", 0, 12));
        forgotPasswordBtn.setForeground(new Color(0, 0, 0, 60));
        forgotPasswordBtn.setHorizontalAlignment(JButton.LEFT);
        forgotPasswordBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                forgotPasswordBtnActionPerformed(evt);
            }
        });
        
        
        

        // Login Button Settings
        loginBtn = new JButton();
        loginBtn.setBackground(new Color(21, 170, 180));
        loginBtn.setRolloverEnabled(false);
        loginBtn.setFocusPainted(false);
        loginBtn.setBorder(null);
        loginBtn.setText("Login");
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        


        // Sign Up Button Settings
        signUpBtn = new JButton("Don't have an account? Sign up");
        signUpBtn.setBackground(new Color(21, 170, 180, 64));
        signUpBtn.setRolloverEnabled(false);
        signUpBtn.setFocusPainted(false);
        signUpBtn.setBorder(null);
        signUpBtn.setPreferredSize(new Dimension(250, 50));
        signUpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });




        // Add main panel to the frame
        getContentPane().add(mainPanel);



        // Main Panel Layout
        GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(imagePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(loginPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(imagePanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(loginPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );



        // Image Panel Layout
        GroupLayout imagePanelLayout = new GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(imagePanelLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(iconLabel) 
                    .addComponent(appNameLabel))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, imagePanelLayout.createSequentialGroup()
                .addContainerGap(1, Short.MAX_VALUE)
                .addComponent(iconLabel) 
                .addGap(20)
                .addComponent(appNameLabel)
                .addContainerGap(100, Short.MAX_VALUE))
        );



        // Login Panel Layout
        GroupLayout loginPanelLayout = new GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
            loginPanelLayout.setHorizontalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(loginPanelLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE) // Add a gap before the components
                    .addComponent(loginLabel)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)) // Add a gap after the components
                .addGroup(loginPanelLayout.createSequentialGroup()
                    .addGap(75) // Add a gap before the components
                    .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(emailText, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                        .addGroup(loginPanelLayout.createSequentialGroup() // Change the group here
                            .addComponent(incorrectPasswordLabel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
                        .addGroup(loginPanelLayout.createSequentialGroup()
                            .addComponent(forgotPasswordBtn, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
                        .addComponent(signUpBtn, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
                    .addGap(75)) // Add a gap after the components
            );
            loginPanelLayout.setVerticalGroup(
                loginPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(loginPanelLayout.createSequentialGroup()
                    .addGap(125)
                    .addComponent(loginLabel)
                    .addGap(25)
                    .addComponent(emailText, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(30)
                    .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(incorrectPasswordLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addGap(10)
                    .addGroup(loginPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(forgotPasswordBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(loginBtn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addGap(100)
                    .addComponent(signUpBtn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addGap(63))
            );



    
        pack();
    }


    private void forgotPasswordBtnActionPerformed(ActionEvent evt) {
       // System.out.println("Forgot Password btn clicked");  
       // incorrectPasswordLabel.setText(" "); 
        ForgotPass ForgotPassFrame = new ForgotPass();
        ForgotPassFrame.setVisible(true);
        ForgotPassFrame.pack();
        ForgotPassFrame.setLocationRelativeTo(null); 
        this.dispose();
    }
    
    private void loginBtnActionPerformed(ActionEvent evt) {

        // get email and password from text fields
        String email = emailText.getText();
        email = email.toLowerCase();
        String password = new String(passwordText.getPassword());

        // check if email is valid
        if (EmailValidator.getInstance().isValid(email)) {
            // email is valid, check if email is in database
            if (isEmailInDatabase(email)) {
                // email exists, get hashed password
                try {
                    String sql = "SELECT password FROM user WHERE email = ?";
                    PreparedStatement stmt = connection.prepareStatement(sql);
                    stmt.setString(1, email);
                    ResultSet result = stmt.executeQuery();
                    
                    if (result.next()) {
                        String hashedPassword = result.getString("password");
                    
                        // compare hashed password with hashed passwordText
                        if (BCrypt.checkpw(password, hashedPassword)) {
                            // if password is correct, go to home page
                            MainScreen mainScreen = new MainScreen(email);
                            mainScreen.setVisible(true);
                            mainScreen.pack();
                            mainScreen.setLocationRelativeTo(null);
                            dispose();
                        } else {
                            // if password is incorrect, display "Incorrect Password!"
                            incorrectPasswordLabel.setText("Incorrect Password!");
                        }
                    } else {
                        // email does not exist
                        incorrectPasswordLabel.setText("Email does not exist");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                // email does not exist
                incorrectPasswordLabel.setText("Email does not exist");
            }


        } else {
            // email is not valid
            incorrectPasswordLabel.setText("Invalid Email");
        }
    }
    
    private boolean isEmailInDatabase(String email) {

        try {
            String sql = "SELECT email FROM user WHERE email = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void signUpBtnActionPerformed(ActionEvent evt) {
        SignUpScreen SignUpFrame = new SignUpScreen();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo(null); 
        this.dispose();
    }



}

