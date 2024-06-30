import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Activate extends JFrame {
    private JComboBox<String> versionDropdown;
    private final JTextArea infoTextArea;
    private Image backgroundImage;

    public Activate() {
        this.setTitle("Windows 10 Activate");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw background image
                try {
                    URL url = new URL("https://c4.wallpaperflare.com/wallpaper/344/958/356/windows-10-windows-10-anniversary-logo-hd-wallpaper-preview.jpg");
                    backgroundImage = ImageIO.read(url);
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        JLabel titleLabel = new JLabel("Windows 10 Activate");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        panel.add(Box.createVerticalStrut(40));
        panel.add(titleLabel);

        String[] versions = {"Home/Core", "Home/Core (Country Specific)", "Home/Core (Single Language)", "Home/Core N",
                "Professional", "Professional N", "Enterprise", "Enterprise N", "Education", "Education N",
                "Enterprise 2015 LTSB", "Enterprise 2015 LTSB N", "Enterprise 2016 LTSB", "Enterprise 2016 LTSB N"};
        versionDropdown = new JComboBox<>(versions);
        versionDropdown.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        versionDropdown.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createVerticalStrut(40));
        panel.add(versionDropdown);

        JPanel infoPanel = new JPanel();
        infoPanel.setOpaque(false);
        infoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        infoPanel.setLayout(new BorderLayout());
        infoTextArea = new JTextArea("Select a Windows version...");
        infoTextArea.setEditable(false);
        infoTextArea.setOpaque(false);
        infoTextArea.setForeground(Color.WHITE);
        infoTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        infoPanel.add(infoTextArea, BorderLayout.CENTER);
        panel.add(Box.createVerticalStrut(20));
        panel.add(infoPanel);

        JButton activateButton = new JButton("Activate");
        activateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        int buttonHeight = activateButton.getPreferredSize().height;
        int bottomMargin = (int) (buttonHeight * 0.1);
        activateButton.setMargin(new Insets(0, 0, bottomMargin, 0));
        activateButton.addActionListener(e -> {
            String selectedVersion = (String) versionDropdown.getSelectedItem();
            if (selectedVersion != null) {
                activateWindows(selectedVersion);
            }
        });
        panel.add(Box.createVerticalStrut(30));
        panel.add(activateButton);

        this.setContentPane(panel);

        setSize(700, 420);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void activateWindows(String version) {
        try {
            String command = getCommandForVersion(version);
            if (command != null) {
                System.out.println("Activating Windows for: " + version);
                System.out.println("Command: " + command);
                String productKey = generateProductKey();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String currentDate = dateFormat.format(new Date());
                String infoText = String.format("Windows 10 (%s)\nProduct Key: %s\nDate: %s\n---------------------------------------------------\nGitHub: %s\nInstagram: %s",
                        version, productKey, currentDate, "https://github.com/ErjonKurti", "@erikurtti");
                infoTextArea.setText(infoText);
            } else {
                System.out.println("No command found for: " + version);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getCommandForVersion(String version) {
        switch (version) {
            case "Home/Core":
                return "cscript slmgr.vbs /ipk TX9XD-98N7V-6WMQ6-BX7FG-H8Q99";
            case "Home/Core (Country Specific)":
                return "cscript slmgr.vbs /ipk PVMJN-6DFY6-9CCP6-7BKTT-D3WVR";
            case "Home/Core (Single Language)":
                return "cscript slmgr.vbs /ipk 7HNRX-D7KGG-3K4RQ-4WPJ4-YTDFH";
            case "Home/Core N":
                return "cscript slmgr.vbs /ipk 3KHY7-WNT83-DGQKR-F7HPR-844BM";
            case "Professional":
                return "cscript slmgr.vbs /ipk W269N-WFGWX-YVC9B-4J6C9-T83GX";
            case "Professional N":
                return "cscript slmgr.vbs /ipk MH37W-N47XK-V7XM9-C7227-GCQG9";
            case "Enterprise":
                return "cscript slmgr.vbs /ipk NPPR9-FWDCX-D2C8J-H872K-2YT43";
            case "Enterprise N":
                return "cscript slmgr.vbs /ipk DPH2V-TTNVB-4X9Q3-TJR4H-KHJW4";
            case "Education":
                return "cscript slmgr.vbs /ipk NW6C2-QMPVW-D7KKK-3GKT6-VCFB2";
            case "Education N":
                return "cscript slmgr.vbs /ipk 2WH4N-8QGBV-H22JP-CT43Q-MDWWJ";
            case "Enterprise 2015 LTSB":
                return "cscript slmgr.vbs /ipk WNMTR-4C88C-JK8YV-HQ7T2-76DF9";
            case "Enterprise 2015 LTSB N":
                return "cscript slmgr.vbs /ipk 2F77B-TNFGY-69QQF-B8YKP-D69TJ";
            case "Enterprise 2016 LTSB":
                return "cscript slmgr.vbs /ipk DCPHK-NFMTC-H88MJ-PFHPY-QJ4BJ";
            case "Enterprise 2016 LTSB N":
                return "cscript slmgr.vbs /ipk QFFDN-GRT3P-VKWWX-X7T3R-8B639";
            default:
                return null;
        }
    }

    private String generateProductKey() {
        return "XXXXX-XXXXX-XXXXX-XXXXX";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Activate());
    }
}
