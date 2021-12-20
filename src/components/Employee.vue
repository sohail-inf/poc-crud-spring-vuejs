<template>
    <div class="container">
        <div>
            <div class="col-md-10 m-5">
                <h2>Employee Management</h2>
            </div>
        </div>
        <hr>
        <form v-on:submit.prevent = "addEmployee">

        <div class="row">
            <div class="col-md-10 m-5">

                <!-- <div class="form-group">
                    <label>ID</label>
                    <input type="text" class="form-control" readonly v-model="EmployeeObj.id">
                </div> -->

                <div class="form-group">
                    <label>First Name</label>
                    <input type="text" class="form-control" placeholder="First Name"  v-model="EmployeeObj.firstName">
                </div>
                <div class="form-group">
                    <label>Last Name</label>
                    <input type="text" class="form-control" placeholder="Last Name" v-model="EmployeeObj.lastName">
                </div>
                <div class="form-group">
                    <label>Email</label>
                    <input type="text" class="form-control" placeholder="Email"  v-model="EmployeeObj.email">
                </div>
                <br>
                <input v-if="!showUpdateBtn" type="submit" class="btn btn-success" value="Add Employee">
                <input v-if="showUpdateBtn" type="button" class="btn btn-success" value="Update" v-on:click="updateTheEmployee()">

            </div>
        </div>
        </form>
        
        <div class="col-md-10 m-5">
                <h2>Employees List</h2>
            </div>
        <table class="table table-striped">
            <thead>
                <th>Employee Id</th>
                <th>Employee First Name</th>
                <th>Employee Last Name</th>
                <th>Employee Email</th>
            </thead>
            <tbody>
                <tr v-for="employee in employees" v-bind:key="employee.id">
                    <td>{{employee.id}}</td>
                    <td>{{employee.firstName}}</td>
                    <td>{{employee.lastName}}</td>
                    <td>{{employee.email}}</td>
                    <td><button type="button" class="btn btn-info" v-on:click="editEmployee(employee.id)">Edit</button></td>
                    <td><button type="button" class="btn btn-danger" v-on:click="deleteTheEmployee(employee.id)">Delete</button></td>
                </tr>
            </tbody>
        </table>
        <br>
    </div>
</template>

<script>
import EmployeeService from "../services/EmployeeService";

    export default {
        name: 'Employees',
        data() {
            return{
                EmployeeObj: {
                    id: '',
                    firstName: '',
                    lastName: '',
                    email: ''
                },
                updateEmployeeObj: {
                    id: '',
                    firstName: '',
                    lastName: '',
                    email: ''
                },
                employees: [],
                showUpdateBtn: false,
            }
        },
        methods: {
            addEmployee() {
            EmployeeService.addNewEmployee(this.EmployeeObj).
            then(response => {
                    console.log(response)
                    this.getEmployees();
                }).
            catch(error => console.log(error))
            },
            getEmployees() {
                EmployeeService.getEmployees().then(
                    response => {this.employees = response.data;}
                )
            },
            editEmployee(id) {
                EmployeeService.findEmployee(id).then(response => {
                    
                    this.EmployeeObj = {
                        id: response.data.id,
                        firstName: response.data.firstName,
                        lastName: response.data.lastName,
                        email: response.data.email
                    }
                    this.showUpdateBtn = true
                }).catch(error => console.log(error))
            },
            updateTheEmployee() {
                EmployeeService.updateEmployee(this.EmployeeObj).then(response => {
                    console.log(response);
                    this.getEmployees();
                    this.EmployeeObj = {}
                    this.showUpdateBtn =  false;
                })
            },
            deleteTheEmployee(id) {
                EmployeeService.deleteEmployee(id).then(response => {
                    console.log(response);
                    this.getEmployees();
                }).catch(error => {
                    console.log(error);
                })
            }
        },
        created() {
            this.getEmployees()
        }
    }
</script>

<style>

</style>
