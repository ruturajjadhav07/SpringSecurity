import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Server from "../Server/Server";
import { useNavigate } from "react-router-dom";

const SignIn = () => {
  const [form, setForm] = useState({ username: "", password: "" });

  let navigate = useNavigate();

  const handleChange = (e) => {
    setForm((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const signin = async (e) => {
    e.preventDefault();
    try {
      const response = await Server.post("/login", form);
      alert("Login Successful");
  
      const token = response.data; // Assuming backend returns JWT token
      localStorage.setItem("token", token); // ✅ Store token
      navigate("/users");
    } catch (error) {
      alert("Login Failed!");
    }
  };
  
  const signup = (e) => {
    e.preventDefault(); // Prevent unwanted submission
    navigate("/signup");
  };

  return (
    <div className="container col-md-4 d-flex justify-content-center align-items-center vh-100">
      <form className="border rounded p-4 w-100">
        <h3 className="text-center">Sign In</h3>
        <div className="form-group my-3">
          <input
            className="form-control"
            type="text"
            placeholder="Username"
            name="username"
            onChange={handleChange}
            value={form.username}
            required
          />
        </div>
        <div className="form-group my-3">
          <input
            className="form-control"
            type="password"
            placeholder="Password"
            name="password"
            onChange={handleChange}
            value={form.password}
            required
          />
        </div>
        <button
          className="btn btn-primary w-100 my-2"
          type="submit"
          onClick={signin}
        >
          Sign In
        </button>
        <button
          className="btn btn-secondary w-100"
          type="button"
          onClick={signup}
        >
          Signup
        </button>
      </form>
    </div>
  );
};

export default SignIn;
