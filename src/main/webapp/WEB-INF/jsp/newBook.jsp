<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1>New Book Registration</h1>

<form:form modelAttribute="form">
    <form:errors path="" element="div"/>
    <div>
        <form:label path="title">Title</form:label>
        <form:input path="title"/>
        <form:errors path="title"/>
    </div>
    <div>
        <form:label path="author">Author</form:label>
        <form:input path="author"/>
        <form:errors path="author"/>
    </div>
    <div>
        <form:label path="isbn">ISBN</form:label>
        <form:input path="isbn"/>
        <form:errors path="isbn"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form:form>
</body>
</html>
