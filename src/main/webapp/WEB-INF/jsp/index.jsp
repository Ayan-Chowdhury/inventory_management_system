<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inventory Management System</title>
</head>
<body>
    <h1>Inventory Management</h1>
    <form method="POST" action="${pageContext.request.contextPath}/addItem">
        <label for="name">Item Name:</label>
        <input type="text" id="name" name="name" required/><br>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" required><br>
        <label for="price">Price:</label>
        <input type="number" step="0.01" id="price" name="price" required><br>
        <button type="submit">Add Item</button>
    </form>
    <h2>Items</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${items}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.quantity}</td>
                    <td>${item.price}</td>
                    <td>
                        <form method="POST" action="${pageContext.request.contextPath}/deleteItem">
                            <input type="hidden" name="id" value="${item.id}">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
