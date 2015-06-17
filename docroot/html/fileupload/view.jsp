<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<portlet:defineObjects />
 
<portlet:actionURL name="upload" var="uploadFileURL"></portlet:actionURL>
<portlet:actionURL name="option" var="createOptionURL"></portlet:actionURL>
 
 <aui:form action="<%= uploadFileURL %>" enctype="multipart/form-data" method="post">
 
<select name="folder">
      <option value="store">Store</option>
      <option value="floor">Floor</option>
      <option value="department">Department</option>
</select>

<aui:input type="file" name="fileupload" />
<aui:button name="Save" value="Save" type="submit" />
</aui:form>