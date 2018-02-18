package com.ewp.crm.controllers.rest;

import com.ewp.crm.exceptions.status.StatusDataException;
import com.ewp.crm.models.Status;
import com.ewp.crm.service.interfaces.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/rest/status")
public class StatusRestController {

	private final StatusService statusService;

	@Autowired
	public StatusRestController(StatusService statusService) {
		this.statusService = statusService;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity addNewStatus(@RequestParam(name = "statusName") String statusName) {

		statusService.add(new Status(statusName));

		return ResponseEntity.ok("Успешно добавлено");
	}

	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public ResponseEntity changeClientStatus(@RequestParam(name = "statusId") Long statusId,
	                                         @RequestParam(name = "clientId") Long clientId) {

		statusService.changeClientStatus(clientId, statusId);

		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity deleteStatus(@RequestParam(name = "deleteId") Long deleteId) {

		statusService.delete(deleteId);

		return ResponseEntity.ok().build();
	}

	@ExceptionHandler(StatusDataException.class)
	public ResponseEntity handleException(StatusDataException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
}