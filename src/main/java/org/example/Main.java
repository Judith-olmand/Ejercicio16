package org.example;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idDep;
        String nombreEmp;
        double salario;
        int idEmp;

        String sql = "SELECT nombre, salario, emp_id FROM empleado WHERE dep_id = ?";

        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()); PreparedStatement ps = conn.prepareStatement(sql)) {
                    System.out.println("Indique el id del departamento");
                    idDep = sc.nextInt();
                    sc.nextLine();

                    ps.setInt(1, idDep);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        nombreEmp = rs.getString(1);
                        salario = rs.getDouble(2);
                        idEmp = rs.getInt(3);
                        System.out.println("Nombre del empleado: " + nombreEmp + " --> salario: " + salario + " --> id: " + idEmp);
                    }
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}