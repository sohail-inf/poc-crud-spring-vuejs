import axios from 'axios'

const GET_EMPLOYEE_API_URL = 'http://localhost:8080/api/employees'
const SAVE_EMPLOYEE_API_URL = 'http://localhost:8080/api/save'
const FIND_EMPLOYEE_API_URL = 'http://localhost:8080/api/find/'
const UPDATE_EMPLOYEE_API_URL = 'http://localhost:8080/api/update'
const DELETE_EMPLOYEE_API_URL = 'http://localhost:8080/api/delete/'

class EmployeeService{

    getEmployees(){
        return axios.get(GET_EMPLOYEE_API_URL)
    }

    addNewEmployee(data){
        return axios.post(SAVE_EMPLOYEE_API_URL, data)
    }

    findEmployee(data){
        return axios.get(FIND_EMPLOYEE_API_URL+data)
    }

    updateEmployee(data){
        return axios.put(UPDATE_EMPLOYEE_API_URL, data)
    }

    deleteEmployee(data){
        return axios.delete(DELETE_EMPLOYEE_API_URL+data)
    }



}

export default new EmployeeService();