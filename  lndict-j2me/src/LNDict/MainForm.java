/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LNDict;

import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
//import javax.microedition.io.*;

/**
 * @author Le Van Long
 */
public class MainForm extends MIDlet implements CommandListener {

    private boolean midletPaused = false;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private Form mainForm;
    private TextField textFieldInput;
    private TextBox txtMean;
    private Alert alert;
    private Command exitCommand;
    private Command searchCommand;
    private Command backCommand;
    private Command okCommand_Alert;
    private Ticker ticker;
    //</editor-fold>//GEN-END:|fields|0|
    
    //IndexElement[] index;

    /**
     * The MainForm constructor.
     */
    public MainForm() {        
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getMainForm());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
        switchDisplayable(null, getMainForm());//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == alert) {//GEN-BEGIN:|7-commandAction|1|37-preAction
            if (command == okCommand_Alert) {//GEN-END:|7-commandAction|1|37-preAction
                // write pre-action user code here
                switchDisplayable(null, getMainForm());//GEN-LINE:|7-commandAction|2|37-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|3|18-preAction
        } else if (displayable == mainForm) {
            if (command == exitCommand) {//GEN-END:|7-commandAction|3|18-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|4|18-postAction
                // write post-action user code here
            } else if (command == searchCommand) {//GEN-LINE:|7-commandAction|5|29-preAction
                // write pre-action user code here
                String meaning = getMeaning();
                if (meaning.compareTo("") != 0)
                {
                    switchDisplayable(null, getTxtMean());
                    txtMean.setString(meaning);
                }
//GEN-LINE:|7-commandAction|6|29-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|7|31-preAction
        } else if (displayable == txtMean) {
            if (command == backCommand) {//GEN-END:|7-commandAction|7|31-preAction
                // write pre-action user code here
                switchDisplayable(null, getMainForm());//GEN-LINE:|7-commandAction|8|31-postAction
                // write post-action user code here
                txtMean.setString("");
            }//GEN-BEGIN:|7-commandAction|9|7-postCommandAction
        }//GEN-END:|7-commandAction|9|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|10|
    //</editor-fold>//GEN-END:|7-commandAction|10|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: mainForm ">//GEN-BEGIN:|14-getter|0|14-preInit
    /**
     * Returns an initiliazed instance of mainForm component.
     * @return the initialized component instance
     */
    public Form getMainForm() {
        if (mainForm == null) {//GEN-END:|14-getter|0|14-preInit
            // write pre-init user code here
            mainForm = new Form("LNDictionary", new Item[] { getTextFieldInput() });//GEN-BEGIN:|14-getter|1|14-postInit
            mainForm.setTicker(getTicker());
            mainForm.addCommand(getExitCommand());
            mainForm.addCommand(getSearchCommand());
            mainForm.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
            // write post-init user code here
        }//GEN-BEGIN:|14-getter|2|
        return mainForm;
    }
    //</editor-fold>//GEN-END:|14-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|17-getter|0|17-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|17-getter|0|17-preInit
            // write pre-init user code here
            exitCommand = new Command("Thoat", Command.EXIT, 0);//GEN-LINE:|17-getter|1|17-postInit
            // write post-init user code here
        }//GEN-BEGIN:|17-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|17-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: textFieldInput ">//GEN-BEGIN:|21-getter|0|21-preInit
    /**
     * Returns an initiliazed instance of textFieldInput component.
     * @return the initialized component instance
     */
    public TextField getTextFieldInput() {
        if (textFieldInput == null) {//GEN-END:|21-getter|0|21-preInit
            // write pre-init user code here
            textFieldInput = new TextField("Input", null, 32, TextField.ANY);//GEN-LINE:|21-getter|1|21-postInit
            // write post-init user code here
        }//GEN-BEGIN:|21-getter|2|
        return textFieldInput;
    }
    //</editor-fold>//GEN-END:|21-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: ticker ">//GEN-BEGIN:|22-getter|0|22-preInit
    /**
     * Returns an initiliazed instance of ticker component.
     * @return the initialized component instance
     */
    public Ticker getTicker() {
        if (ticker == null) {//GEN-END:|22-getter|0|22-preInit
            // write pre-init user code here
            ticker = new Ticker("Chao mung ban den voi LNDictionary");//GEN-LINE:|22-getter|1|22-postInit
            // write post-init user code here
        }//GEN-BEGIN:|22-getter|2|
        return ticker;
    }
    //</editor-fold>//GEN-END:|22-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: txtMean ">//GEN-BEGIN:|27-getter|0|27-preInit
    /**
     * Returns an initiliazed instance of txtMean component.
     * @return the initialized component instance
     */
    public TextBox getTxtMean() {
        if (txtMean == null) {//GEN-END:|27-getter|0|27-preInit
            // write pre-init user code here
            txtMean = new TextBox("Nghia", null, 2000, TextField.ANY);//GEN-BEGIN:|27-getter|1|27-postInit
            txtMean.addCommand(getBackCommand());
            txtMean.setCommandListener(this);//GEN-END:|27-getter|1|27-postInit
            // write post-init user code here
        }//GEN-BEGIN:|27-getter|2|
        return txtMean;
    }
    //</editor-fold>//GEN-END:|27-getter|2|
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: searchCommand ">//GEN-BEGIN:|28-getter|0|28-preInit
    /**
     * Returns an initiliazed instance of searchCommand component.
     * @return the initialized component instance
     */
    public Command getSearchCommand() {
        if (searchCommand == null) {//GEN-END:|28-getter|0|28-preInit
            // write pre-init user code here
            searchCommand = new Command("Tra cuu", Command.OK, 0);//GEN-LINE:|28-getter|1|28-postInit
            // write post-init user code here
        }//GEN-BEGIN:|28-getter|2|
        return searchCommand;
    }
    //</editor-fold>//GEN-END:|28-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|30-getter|0|30-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|30-getter|0|30-preInit
            // write pre-init user code here
            backCommand = new Command("Tro lai", Command.BACK, 0);//GEN-LINE:|30-getter|1|30-postInit
            // write post-init user code here
        }//GEN-BEGIN:|30-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|30-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alert ">//GEN-BEGIN:|35-getter|0|35-preInit
    /**
     * Returns an initiliazed instance of alert component.
     * @return the initialized component instance
     */
    public Alert getAlert() {
        if (alert == null) {//GEN-END:|35-getter|0|35-preInit
            // write pre-init user code here
            alert = new Alert("Error");//GEN-BEGIN:|35-getter|1|35-postInit
            alert.addCommand(getOkCommand_Alert());
            alert.setCommandListener(this);
            alert.setTimeout(Alert.FOREVER);//GEN-END:|35-getter|1|35-postInit
            // write post-init user code here
        }//GEN-BEGIN:|35-getter|2|
        return alert;
    }
    //</editor-fold>//GEN-END:|35-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand_Alert ">//GEN-BEGIN:|36-getter|0|36-preInit
    /**
     * Returns an initiliazed instance of okCommand_Alert component.
     * @return the initialized component instance
     */
    public Command getOkCommand_Alert() {
        if (okCommand_Alert == null) {//GEN-END:|36-getter|0|36-preInit
            // write pre-init user code here
            okCommand_Alert = new Command("Ok", Command.OK, 0);//GEN-LINE:|36-getter|1|36-postInit
            // write post-init user code here
        }//GEN-BEGIN:|36-getter|2|
        return okCommand_Alert;
    }
    //</editor-fold>//GEN-END:|36-getter|2|

    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

    // Cài đặt hàm để hiển thị các thông báo
    public void displayMessage(String message, String title)
    {
        switchDisplayable(null, getAlert());
        if (message != null)
        {
            alert.setString(message);
        }

        if (title != null)
        {
            alert.setTitle(title);
        }
    }

    public String getMeaning()
    {
        String result = "";
        String word = this.textFieldInput.getString();
        word = word.toLowerCase();
        if (word.length() > 0)
        {
            char firstChar = word.charAt(0);
            String fileName = "";
            if (Character.isDigit(firstChar))
            {
                fileName = "av_0";
            }
            else
            {
                fileName = "av_" + firstChar;
            }

            InputStream indexStream = this.getClass().getResourceAsStream(fileName + ".index");
            if (indexStream != null)
            {
                try
                {
                    Vector arrIndexes = Processor.readFromFile(indexStream);
                    // Lấy vị trí từ cần tra và lấy nghĩa
                    int index = Processor.binarySearch(word, arrIndexes);
                    if (index != -1)
                    {
                        InputStream meaningStream = this.getClass().getResourceAsStream(fileName + ".meaning");
                        try
                        {
                            int meaningPosition = ((IndexElement)arrIndexes.elementAt(index)).getPosition();
                            int meaningLength = ((IndexElement)arrIndexes.elementAt(index)).getLength();
                            result = Processor.readMeaningString(meaningStream, meaningPosition, meaningLength);

                            // Hủy
                            meaningStream.close();
                            indexStream.close();
                            arrIndexes.removeAllElements();
                        }
                        catch (Exception ex)
                        {
                            displayMessage(ex.getMessage(), "Loi");
                        }
                    }
                    else
                    {
                        displayMessage("Khong tim thay tu can tra", "");
//-------------------------------------------------------------------------//
//Bổ sung nghĩa chỗ này
//-------------------------------------------------------------------------//
                    }
                }
                catch (Exception ex)
                {
                    displayMessage(ex.getMessage(), "Loi");
                }
            }
            else
            {
                displayMessage("Khong tim thay file " + fileName + ".index", "Loi du lieu");
            }
        }
        else
        {
            displayMessage("Ban chua nhap tu can tra", "");
        }

        return result;
    }
}
