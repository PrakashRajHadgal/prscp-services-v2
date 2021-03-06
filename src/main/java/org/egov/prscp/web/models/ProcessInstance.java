package org.egov.prscp.web.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.egov.common.contract.request.User;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = { "id" })
@ToString
public class ProcessInstance {

	@Size(max = 64)
	@JsonProperty("id")
	private String id = null;

	@NotNull
	@Size(max = 128)
	@JsonProperty("tenantId")
	private String tenantId = null;

	@NotNull
	@Size(max = 128)
	@JsonProperty("businessService")
	private String businessService = null;

        @NotNull
        @Size(max=128)
        @JsonProperty("businessId")
        private String businessId;

	@NotNull
	@Size(max = 128)
	@JsonProperty("action")
	private String action = null;

	@NotNull
	@Size(max = 64)
	@JsonProperty("moduleName")
	private String moduleName = null;

	@JsonProperty("state")
	private State state = null;

	@JsonProperty("comment")
	private String comment = null;

	@JsonProperty("documents")
	@Valid
	private List<Document> documents = null;

	@JsonProperty("assigner")
	private User assigner = null;

	@JsonProperty("assignee")
	private User assignee = null;

	@JsonProperty("nextActions")
	@Valid
	private List<Action> nextActions = null;

	@JsonProperty("stateSla")
	private Long stateSla = null;

	@JsonProperty("businesssServiceSla")
	private Long businesssServiceSla = null;

	@JsonProperty("previousStatus")
	@Size(max = 128)
	private String previousStatus = null;

	@JsonProperty("entity")
	private Object entity = null;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;

	public ProcessInstance addDocumentsItem(Document documentsItem) {
		if (this.documents == null) {
			this.documents = new ArrayList<>();
		}
		if (!this.documents.contains(documentsItem))
			this.documents.add(documentsItem);

		return this;
	}

	public ProcessInstance addNextActionsItem(Action nextActionsItem) {
		if (this.nextActions == null) {
			this.nextActions = new ArrayList<>();
		}
		this.nextActions.add(nextActionsItem);
		return this;
	}

}
