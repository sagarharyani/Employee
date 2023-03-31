<html>
<body>
<h2>Hello World!</h2>

<h3>Create User</h3>
<form action="createUser">
Id <input type = "text" name="id"><br>
Name <input type = "text" name="name"><br>
Address <input type = "text" name="address"><br>
Gender <input type = "text" name="gender"><br><br>
<input type = "submit">
</form>
<br>

<h3>Display All User</h3>
<form action="displayAllUser">
<input type = "submit"><br>
</form>
<br>

<h3>Display User By ID</h3>
<form action="displayUserById">
Id <input type = "text" name="id"><br><br>
<input type = "submit">
</form>

<h3>Update User By ID</h3>
<form action="updateUserById">
Id <input type = "text" name="id"><br>
Field <input type = "text" name="field"><br>
Value <input type = "text" name="value"><br><br>
<input type = "submit">
</form>


<h3>Delete User By ID</h3>
<form action="deleteUserById">
Id <input type = "text" name="id"><br><br>
<input type = "submit">
</form>


</body>
</html>
