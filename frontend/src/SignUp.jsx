import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import Server from "../Server/Server";

const SignUp = () => {
  const [form, setForm] = useState({ username: "", password: "" });

  const handleChange = (e) => {
    setForm((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const submit = async (e) => {
    e.preventDefault();

    try {
      const response = await Server.post("/register", form); 
    //   console.log("Registration Successful:", response.data);
      alert("Registration Successful!");
    } catch (error) {
      console.error("Error:", error);
      alert("Registration Failed!");
    }
  };

  return (
    <div className="container col-md-4 d-flex justify-content-center align-items-center vh-100">
      <form className="border rounded p-4 w-100" onSubmit={submit}>
        <h3 className="text-center">Sign Up</h3>
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
        <button className="btn btn-primary w-100" type="submit">
          Signup
        </button>
      </form>
    </div>
  );
};

export default SignUp;
