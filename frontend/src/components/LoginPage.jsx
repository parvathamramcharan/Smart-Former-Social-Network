import React from "react";
import { FaUserAlt, FaUserShield } from "react-icons/fa";
//above is react icons , fa-> fontawesome
import applogo from "../assets/images/applogo.png";
import "./LoginPage.css";
const LoginPage = () => {
  return (
    <div>
      <div className="login-page">
        <div className="header">
          <div className="logo-circle">
            <img src={applogo} alt="AgroConnect Logo" />
          </div>
          <h2>AgroConnect</h2>
          <p>Connect, Share, and Grow Together</p>
        </div>

        <div className="role-card">
          <h3>Welcome to AgroConnect</h3>
          <p>Select your role to continue</p>
          <div className="roles-container">
            <div className="role-item">
              <FaUserAlt className="role-icon" />
              <div className="role-info">
                <h4>Farmer</h4>
                <p>Share your farming experience and connect with community</p>
              </div>
              <div className="arrow">→</div>
            </div>
            <div className="role-item">
              <FaUserShield className="role-icon" />
              <div className="role-info">
                <h4>Admin</h4>
                <p>Manage platform and support the farming community</p>
              </div>
              <div className="arrow">→</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
