import { useEffect, useState } from "react";
import Server from "../Server/Server";

const Users = () => {
  const [data, setData] = useState([]);
  const token = localStorage.getItem("token"); // ✅ Get token

  useEffect(() => {
    const fetchUsers = async () => {
      try {
        const response = await Server.get("/users", {
          headers: { Authorization: `Bearer ${token}` }, // ✅ Send token
        });
        setData(response.data);
      } catch (error) {
        console.error("Error fetching users:", error.message);
      }
    };

    fetchUsers();
  }, []);

  return (
    <div>
      <ul>
        {data.map((user, index) => (
          <li key={index}>{user.username}</li>
        ))}
      </ul>
    </div>
  );
};

export default Users;
