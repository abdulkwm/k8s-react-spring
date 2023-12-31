import axios from "axios";
import { useState, useEffect } from "react"
const baseURL = "http://localhost:8080/api/employees"
const EmployeeList = () => {
    const [employees, setEmployees] = useState([]);
    useEffect(() => {
        const fetchEmployees = async () => {
            try {
                const response = await axios.get(baseURL || process.env.React_APP_URL);
                setEmployees(response.data);
            } catch (error) {
                console.error("error fetching employees", error);
            }
        };
        fetchEmployees();
    }, [])
    return (
        <div>
            <h2>Employee List</h2>
            <table>
                <thead>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>email</th>
                </tr>
                </thead>
                <tbody>
                    {employees.map(employee => (
                        <tr key={employee.id}>
                        <td>{employee.id}</td>
                        <td>{employee.name}</td>
                        <td>{employee.email}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};
export default EmployeeList;
