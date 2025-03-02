# Javalin: Request and Response Methods

### **Request Methods**

1. **`body()`**: Retrieves the request body as a string.

```java
app.post("/body-example", ctx -> {
    String bodyContent = ctx.body(); // Get the body content as a string
    ctx.result("Received body: " + bodyContent);
});
```
**Output** (for a POST request with body `{"name":"John"}`):
```
Received body: {"name":"John"}
```

2. **`pathParam("name")`**: Retrieves a path parameter by name as a string.

```java
app.get("/hello/{name}", ctx -> {
    String name = ctx.pathParam("name"); // Get the path parameter "name"
    ctx.result("Hello, " + name);
});
```
**Output** (for a GET request to `/hello/John`):
```
Hello, John
```

3. **`attribute("name", value)`**: Sets an attribute on the request.

```java
app.get("/set-attribute", ctx -> {
    ctx.attribute("user", "John Doe"); // Set an attribute "user" with value "John Doe"
    ctx.result("Attribute set successfully!");
});
```
**Output** (when a GET request is made to `/set-attribute`):
```
Attribute set successfully!
```

4. **`attribute("name")`**: Retrieves an attribute from the request.

```java
app.get("/get-attribute", ctx -> {
    String user = ctx.attribute("user"); // Retrieve the "user" attribute
    ctx.result("User attribute: " + user);
});
```
**Output** (when a GET request is made to `/get-attribute` after setting the attribute in a previous route):
```
User attribute: John Doe
```

5. **`path()`**: Retrieves the full request path.

```java
app.get("/path-example/*", ctx -> {
    String path = ctx.path(); // Get the full path
    ctx.result("Request path: " + path);
});
```
**Output** (for a GET request to `/path-example/anything`):
```
Request path: /path-example/anything
```

6. **`method()`**: Retrieves the HTTP method (GET, POST, etc.) for the request.

```java
app.get("/method-example", ctx -> {
    String method = ctx.method(); // Get the HTTP method of the request
    ctx.result("Request method: " + method);
});
```
**Output** (for a GET request to `/method-example`):
```
Request method: GET
```

7. **`queryParam("name")`**: Retrieves a query parameter by name as a string.

```java
app.get("/query-example", ctx -> {
    String name = ctx.queryParam("name"); // Get the query parameter "name"
    ctx.result("Query parameter: " + name);
});
```
**Output** (for a GET request to `/query-example?name=John`):
```
Query parameter: John
```

### **Response Methods**

1. **`redirect("/path", code)`**: Redirects the response to a specified path with an optional status code.

```java
app.get("/redirect-example", ctx -> {
    ctx.redirect("/new-path", 302); // Redirect to "/new-path" with status code 302 (Found)
});
```
**Output** (for a GET request to `/redirect-example`):
The browser will be redirected to `/new-path`.

2. **`status(code)`**: Sets the response status code.

```java
app.get("/status-example", ctx -> {
    ctx.status(404); // Set the response status code to 404 (Not Found)
    ctx.result("Page not found!");
});
```
**Output** (for a GET request to `/status-example`):
The response will have a status of `404 Not Found` with the message `"Page not found!"`.

3. **`status()`**: Retrieves the response status code.

```java
app.get("/get-status", ctx -> {
    ctx.status(200); // Set the status code
    int status = ctx.status(); // Retrieve the response status code
    ctx.result("Response status code: " + status);
});
```
**Output** (for a GET request to `/get-status`):
```
Response status code: 200
```

---

### Summary of Methods and Outputs

| **Request Method**         | **Explanation**                                           | **Example Output**                     |
|----------------------------|-----------------------------------------------------------|----------------------------------------|
| `body()`                   | Retrieves request body as string                          | `Received body: {"name":"John"}`       |
| `pathParam("name")`        | Retrieves path parameter as string                        | `Hello, John`                          |
| `attribute("name", value)` | Sets an attribute on the request                          | `Attribute set successfully!`          |
| `attribute("name")`        | Retrieves an attribute from the request                   | `User attribute: John Doe`             |
| `path()`                   | Retrieves full request path                               | `Request path: /path-example/anything` |
| `method()`                 | Retrieves HTTP method                                     | `Request method: GET`                  |
| `queryParam("name")`       | Retrieves query parameter by name as string               | `Query parameter: John`                |

| **Response Method**        | **Explanation**                                           | **Example Output**                     |
|----------------------------|-----------------------------------------------------------|----------------------------------------|
| `redirect("/path", code)`  | Redirects the response with a given status code           | Redirect to `/new-path` (302 status)   |
| `status(code)`             | Sets the response status code                             | `404 Not Found` with message `"Page    |
|                            |                                                           | not found!"`                           |
| `status()`                 | Retrieves the response status code                        | `Response status code: 200`            |

These methods in Javalin provide essential functionality for both extracting data from HTTP requests and controlling the HTTP response.