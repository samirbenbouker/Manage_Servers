# Manage_Servers
In this project, I have created a Spring Boot backend API that will connect to a MySQL database server. Then create an Agular application to interact with the API using HTTP. I also use some RxJ basics and application state management.

![manage_server_img_curt](https://user-images.githubusercontent.com/57891254/138910265-697d8fca-e06b-40e5-9ee2-d3af0272256f.png)

```
WARNING IN FILE APPLICATION.PROPERTIES ADD USERNAME AND PASSWORD FOR YOUR DATABASE
```

## Path Java Project:
`server/src/main/java/com/samirbenbouker/server/`

## Path Angular Project:
`serverApp/src/app/`

### Execute Angular Project:
```
ng serve
```

## Endpoints API:
```
PATH: localhost:8080/api/v1/server
```
- `Get /list` return all servers we found in database.
- `Get /get/{id}` return server with that id we passed.
- `Get /ping/{ipAddress}` pinged a server with ip address we passed.
- `Get /image/server1.png` return image servers we found in database.
- `Post /save` we can save a server in frontend and database.
- `Delete /delete/{id}` delete server with that id we passed.

### Get All Servers
_This endpoint return a Response and we can get all server we found in database_
<table>
  <tr>
    <th>Response: Response </th>
  </tr>
  <tr>
    <th>Get /list </th>
  </tr>
  <tr>
    <td>No parameters required</td>
  </tr>
</table>

### Get Server By Id
_This endpoint return a Response and we can get a server with that id we passed_
<table>
  <tr>
    <th colspan="4" >Response: Response </th>
  </tr>
  <tr>
    <th colspan="4" >Get /get/{id} </th>
  </tr>
    <tr>
    <th>Param</th>
    <th>Values</th>
    <th>Description</th>
    <th>Required</th>
  </tr>
  <tr>
    <td>id</td>
    <td>Long</td>
    <td>Contains the id of the server</td>
    <td>Yes</td>
  </tr>
</table>

### Get Server By Ip Address
_This endpoint return a Response and we can a pinged a server with ip address we passed_
<table>
  <tr>
    <th colspan="4" >Response: Response </th>
  </tr>
  <tr>
    <th colspan="4" >Get /ping/{ipAddress} </th>
  </tr>
    <tr>
    <th>Param</th>
    <th>Values</th>
    <th>Description</th>
    <th>Required</th>
  </tr>
  <tr>
    <td>ipAddress</td>
    <td>String</td>
    <td>Contains the ip address of the server</td>
    <td>Yes</td>
  </tr>
</table>

### Get Server Image
_This endpoint return a Response and we can get a image server we found in database_
<table>
  <tr>
    <th>Response: Response </th>
  </tr>
  <tr>
    <th>Get /image/server1.png </th>
  </tr>
  <tr>
    <td>No parameters required</td>
  </tr>
</table>

### Post All Servers
_This endpoint return a Response and we can add a server in database_
<table>
  <tr>
    <th>Response: Response </th>
  </tr>
  <tr>
    <th>Post /save </th>
  </tr>
  <tr>
    <td>No parameters required</td>
  </tr>
</table>

### Delete Server By Id
_This endpoint return a Response and we can delete a server with id server_
<table>
  <tr>
    <th colspan="4" >Response: Response </th>
  </tr>
  <tr>
    <th colspan="4" >Delete /delete/{id} </th>
  </tr>
    <tr>
    <th>Param</th>
    <th>Values</th>
    <th>Description</th>
    <th>Required</th>
  </tr>
  <tr>
    <td>id</td>
    <td>Long</td>
    <td>Contains the id of the server</td>
    <td>Yes</td>
  </tr>
</table>
