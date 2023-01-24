package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bmi_cal;

    @FXML
    private TextField enter_height;

    @FXML
    private TextField enter_weight;

    @FXML
    private Label judge;

    @FXML
    private Label result;

    @FXML
    void onBmi_calAction(ActionEvent event) {
    	String judge_list[] = {"低体重｜痩せすぎ", "低体重｜痩せ", "低体重｜痩せぎみ", "普通体重",
                               "過体重｜肥満予備軍", "過体重｜肥満（1度）", "過体重｜肥満（2度）", "過体重｜肥満（3度）"};
    	String eh = enter_height.getText();
    	String ew = enter_weight.getText();
    	try {
    		double deh = Double.parseDouble(eh);
    		double dew = Double.parseDouble(ew);
    		double result_temp =  dew / (deh * deh / 10000);
    		result.setText(String.format("%.3f", result_temp));
    		double res = Double.parseDouble(result.getText());
    	    if (res < 0 || deh <= 0) {
    	    	result.setText("error");
    			judge.setText("入力エラー");
    		}else if (res < 16) {
    			judge.setText(judge_list[0]);
    		}else if (res <17) {
    			judge.setText(judge_list[1]);
    		}else if (res < 18.5) {
    			judge.setText(judge_list[2]);
    		}else if (res < 25) {
    			judge.setText(judge_list[3]);
    		}else if (res < 30) {
    			judge.setText(judge_list[4]);
    		}else if (res < 35) {
    			judge.setText(judge_list[5]);
    		}else if (res < 40) {
    			judge.setText(judge_list[6]);
    		}else{
    			judge.setText(judge_list[7]);
    		}
    	} catch(Exception e) {
    		result.setText("error");
    		judge.setText("入力エラー");
    	} finally {
    		System.out.println("Done");
    	}

    }

    @FXML
    void initialize() {
        assert bmi_cal != null : "fx:id=\"bmi_cal\" was not injected: check your FXML file 'BMI_cal.fxml'.";
        assert enter_height != null : "fx:id=\"enter_height\" was not injected: check your FXML file 'BMI_cal.fxml'.";
        assert enter_weight != null : "fx:id=\"enter_weight\" was not injected: check your FXML file 'BMI_cal.fxml'.";
        assert judge != null : "fx:id=\"judge\" was not injected: check your FXML file 'BMI_cal.fxml'.";
        assert result != null : "fx:id=\"result\" was not injected: check your FXML file 'BMI_cal.fxml'.";

    }

}
