/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author hani
 */
public class FXMLController implements Initializable {

    int n = 0;
    @FXML
    private TableView table1, powerTable;
    @FXML
    private TableColumn T1time, T1power, T1adc, T1obc, T2time, T2value;

    @FXML
    private Button pushBtn;

    ObservableList<Telemetry> data
            = FXCollections.observableArrayList();

    @FXML
    private StackedAreaChart chart1;
    XYChart.Series<Number, Number> seriesPower
            = new XYChart.Series<Number, Number>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        getTelemetry();
        initializeTab1();
        initializeTab2();

        pushBtn.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println("Entered");
                n = n + (int) (Math.random() * 200 + 1);
                seriesPower.getData().add(new XYChart.Data(n, (int) (Math.random() * 200 + 1)));
                data.add(0, new Telemetry(n, String.valueOf((Math.random() * 200 + 1)), String.valueOf((Math.random() * 200 + 1)), String.valueOf((Math.random() * 200 + 1))));

            }
        });

    }

    public void initializeTab1() {
        T1time.setCellValueFactory(
                new PropertyValueFactory<Telemetry, String>("time")
        );

        T1power.setCellValueFactory(
                new PropertyValueFactory<Telemetry, String>("power")
        );

        T1adc.setCellValueFactory(
                new PropertyValueFactory<Telemetry, String>("adc")
        );

        T1obc.setCellValueFactory(
                new PropertyValueFactory<Telemetry, String>("obc")
        );

        table1.setItems(data);

    }

    public void initializeTab2() {
        chart1.setTitle("Power Subsytem");

        chart1.getData().addAll(seriesPower);
    
        T2time.setCellValueFactory(
                new PropertyValueFactory<Telemetry, String>("time")
        );

        T2value.setCellValueFactory(
                new PropertyValueFactory<Telemetry, String>("power")
        );

        powerTable.setItems(data);

    }

    public static class Telemetry {

        private final SimpleIntegerProperty time;
        private final SimpleStringProperty power;
        private final SimpleStringProperty adc;
        private final SimpleStringProperty obc;

        private Telemetry(int time, String power, String adc, String obc) {
            this.time = new SimpleIntegerProperty(time);
            this.power = new SimpleStringProperty(power);
            this.adc = new SimpleStringProperty(adc);
            this.obc = new SimpleStringProperty(obc);
        }

        public int getTime() {
            return time.get();
        }

        public void setTime(int t) {
            time.set(t);
        }

        public String getPower() {
            return power.get();
        }

        public void setPower(String powerS) {
            power.set(powerS);
        }

        public String getadc() {
            return adc.get();
        }

        public void setadc(String adcS) {
            adc.set(adcS);
        }

        public String getObc() {
            return obc.get();
        }

        public void setObc(String obcS) {
            obc.set(obcS);
        }

    }

    public void getTelemetry() {
        data
                = FXCollections.observableArrayList(
                        new Telemetry(4, "899", "453", "4364564"),
                        new Telemetry(12, "100", "9955", "657"),
                        new Telemetry(6, "324234", "657", "343242"),
                        new Telemetry(20, "453", "4364564", "324234")
                );

        data.add(0, new Telemetry(5, "657", "324234", "453"));
    }
}
