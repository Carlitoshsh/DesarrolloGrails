<%@ page import="testdesarrollo.Post" %>



<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'topic', 'error')} required">
	<label for="topic">
		<g:message code="post.topic.label" default="Topic" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="topic" maxlength="50" required="" value="${postInstance?.topic}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'lastUpdate', 'error')} required">
	<label for="lastUpdate">
		<g:message code="post.lastUpdate.label" default="Last Update" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="lastUpdate" precision="day"  value="${postInstance?.lastUpdate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'isAllowed', 'error')} ">
	<label for="isAllowed">
		<g:message code="post.isAllowed.label" default="Is Allowed" />
		
	</label>
	<g:checkBox name="isAllowed" value="${postInstance?.isAllowed}" />

</div>

