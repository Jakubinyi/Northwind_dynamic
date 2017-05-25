package dao;

import org.json.JSONArray;
import org.json.JSONObject;
import util.ConnectionUtil;

import java.sql.*;

/**
 * Created by jakubinyi on 2017.05.23..
 */
public class DatabaseNorthwind implements NorthwindDao {

    Connection conn = ConnectionUtil.getConnection(ConnectionUtil.DatabaseName.NORTHWIND);

    @Override
    public JSONArray executeQuery(String query) {
        JSONArray jsonArray = new JSONArray();

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            while (resultSet.next()) {
                int numColumns = resultSetMetaData.getColumnCount();
                JSONObject jsonObject = new JSONObject();

                for (int i=1; i<numColumns+1; i++) {
                    String column_name = resultSetMetaData.getColumnName(i);
                    jsonObject.put(column_name, resultSet.getObject(column_name) == null ? "null" : resultSet.getObject(column_name));

                   /* if(resultSetMetaData.getColumnType(i)== Types.ARRAY){
                        jsonObject.put(column_name, resultSet.getArray(column_name));
                    }
                    else if(resultSetMetaData.getColumnType(i)== Types.BIGINT){
                        jsonObject.put(column_name, resultSet.getInt(column_name));
                    }
                    else if(resultSetMetaData.getColumnType(i)== Types.BOOLEAN){
                        jsonObject.put(column_name, resultSet.getBoolean(column_name));
                    }
                    else if(resultSetMetaData.getColumnType(i)== Types.BLOB){
                        jsonObject.put(column_name, resultSet.getBlob(column_name));
                    }
                    else if(resultSetMetaData.getColumnType(i)== Types.DOUBLE){
                        jsonObject.put(column_name, resultSet.getDouble(column_name));
                    }
                    else if(resultSetMetaData.getColumnType(i)== Types.FLOAT){
                        jsonObject.put(column_name, resultSet.getFloat(column_name));
                    }
                    else if(resultSetMetaData.getColumnType(i)== Types.INTEGER){
                        jsonObject.put(column_name, resultSet.getInt(column_name));
                    }
                    else if(resultSetMetaData.getColumnType(i)== Types.NVARCHAR){
                        jsonObject.put(column_name, resultSet.getNString(column_name));
                    }
                    else if(resultSetMetaData.getColumnType(i)== Types.VARCHAR){
                        jsonObject.put(column_name, resultSet.getString(column_name));
                    }
                    else if(resultSetMetaData.getColumnType(i)== Types.TINYINT){
                        jsonObject.put(column_name, resultSet.getInt(column_name));
                    }
                    else if(resultSetMetaData.getColumnType(i)== Types.SMALLINT){
                        jsonObject.put(column_name, resultSet.getInt(column_name));
                    }
                    else if(resultSetMetaData.getColumnType(i)== Types.DATE){
                        jsonObject.put(column_name, resultSet.getDate(column_name));
                    }
                    else if(resultSetMetaData.getColumnType(i)== Types.TIMESTAMP){
                        jsonObject.put(column_name, resultSet.getTimestamp(column_name));
                    }
                    else{
                        jsonObject.put(column_name, resultSet.getObject(column_name));
                    }*/
                }
                jsonArray.put(jsonObject);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

}
