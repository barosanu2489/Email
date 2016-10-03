package com.barosanu.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.barosanu.controller.services.MessageRendererService;
import com.barosanu.model.EmailMessageBean;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;

public class EmailDetailsController extends AbstractController implements Initializable {
	
	public EmailDetailsController(ModelAccess modelAccess) {
		super(modelAccess);
	}

    @FXML
    private WebView webView;
    @FXML
    private Label subjectLabel;
    @FXML
    private Label SenderLabel;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		EmailMessageBean selectedMessage = getModelAccess().getSelectedMessage();
		
		
		subjectLabel.setText("Subject: " + selectedMessage.getSubject());
		SenderLabel.setText("Sender: " + selectedMessage.getSender());
		
		MessageRendererService messageRendererService = new MessageRendererService(webView.getEngine());
		messageRendererService.setMessageToRender(selectedMessage);
		Platform.runLater(messageRendererService);

	}

}