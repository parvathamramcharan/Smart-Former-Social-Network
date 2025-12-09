import { useState } from "react";
import { useNavigate } from "react-router-dom";

import { Sprout, Mail, Lock, User, Shield, ArrowLeft } from "lucide-react";

export default function LoginPage() {
  const navigate = useNavigate();
  const { setCurrentUser } = useApp();

  const [step, setStep] = useState("role"); 
  const [isLogin, setIsLogin] = useState(true);

  const [formData, setFormData] = useState({
    name: "",
    email: "",
    password: "",
    role: "farmer", 
  });

  const handleRoleSelect = (role) => {
    setFormData({ ...formData, role });
    setStep("auth");
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const user = {
      id: "1",
      name: formData.name || formData.email.split("@")[0],
      email: formData.email,
      role: formData.role,
      avatar:
        "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?w=150",
      joinedOn: new Date().toISOString(),
    };

    setCurrentUser(user);
    navigate("/home");
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-green-50 to-emerald-100 flex items-center justify-center p-4">
      <div className="w-full max-w-md">
        <div className="text-center mb-8">
          <div className="inline-flex items-center justify-center w-16 h-16 bg-green-600 rounded-full mb-4">
            <Sprout className="w-8 h-8 text-white" />
          </div>
          <h1 className="text-green-900 mb-2">AgroConnect</h1>
          <p className="text-green-700">Connect, Share, and Grow Together</p>
        </div>

        {step === "role" && (
          <div className="bg-white rounded-2xl shadow-xl p-8">
            <h2 className="text-gray-900 text-center mb-2">
              Welcome to AgroConnect
            </h2>
            <p className="text-gray-600 text-center mb-8">
              Select your role to continue
            </p>

            <div className="space-y-4">
              <button
                onClick={() => handleRoleSelect("farmer")}
                className="w-full p-6 border-2 border-gray-200 rounded-xl hover:border-green-500 hover:bg-green-50 group"
              >
                <div className="flex items-center gap-4">
                  <div className="w-14 h-14 bg-green-100 rounded-xl flex items-center justify-center group-hover:bg-green-200">
                    <User className="w-7 h-7 text-green-600" />
                  </div>
                  <div className="flex-1 text-left">
                    <h3 className="text-gray-900 mb-1">Farmer</h3>
                    <p className="text-gray-600">
                      Share your farming experiences
                    </p>
                  </div>
                  <span className="text-gray-400 group-hover:text-green-600">
                    →
                  </span>
                </div>
              </button>

              <button
                onClick={() => handleRoleSelect("admin")}
                className="w-full p-6 border-2 border-gray-200 rounded-xl hover:border-green-500 hover:bg-green-50 group"
              >
                <div className="flex items-center gap-4">
                  <div className="w-14 h-14 bg-blue-100 rounded-xl flex items-center justify-center group-hover:bg-blue-200">
                    <Shield className="w-7 h-7 text-blue-600" />
                  </div>
                  <div className="flex-1 text-left">
                    <h3 className="text-gray-900 mb-1">Admin</h3>
                    <p className="text-gray-600">
                      Manage platform & community
                    </p>
                  </div>
                  <span className="text-gray-400 group-hover:text-green-600">
                    →
                  </span>
                </div>
              </button>
            </div>
          </div>
        )}

        {step === "auth" && (
          <div className="bg-white rounded-2xl shadow-xl p-8">
            <button
              onClick={() => setStep("role")}
              className="flex items-center gap-2 text-gray-600 hover:text-gray-900 mb-6"
            >
              <ArrowLeft className="w-4 h-4" /> Change Role
            </button>

            {/* role badge */}
            <div className="flex items-center gap-3 mb-6">
              <div
                className={`w-10 h-10 rounded-lg flex items-center justify-center ${
                  formData.role === "farmer"
                    ? "bg-green-100"
                    : "bg-blue-100"
                }`}
              >
                {formData.role === "farmer" ? (
                  <User className="w-5 h-5 text-green-600" />
                ) : (
                  <Shield className="w-5 h-5 text-blue-600" />
                )}
              </div>
              <div>
                <p className="text-gray-900 capitalize">{formData.role}</p>
                <p className="text-gray-600">Login or Register</p>
              </div>
            </div>

            {/* login/register toggle */}
            <div className="flex gap-2 mb-6">
              <button
                onClick={() => setIsLogin(true)}
                className={`flex-1 py-2.5 rounded-lg ${
                  isLogin ? "bg-green-600 text-white" : "bg-gray-100"
                }`}
              >
                Login
              </button>
              <button
                onClick={() => setIsLogin(false)}
                className={`flex-1 py-2.5 rounded-lg ${
                  !isLogin ? "bg-green-600 text-white" : "bg-gray-100"
                }`}
              >
                Register
              </button>
            </div>

            {/* form */}
            <form onSubmit={handleSubmit} className="space-y-4">
              {!isLogin && (
                <div>
                  <label className="block text-gray-700 mb-2">Full Name</label>
                  <div className="relative">
                    <User className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400 w-5 h-5" />
                    <input
                      type="text"
                      value={formData.name}
                      onChange={(e) =>
                        setFormData({ ...formData, name: e.target.value })
                      }
                      required
                      className="w-full pl-10 py-3 border rounded-lg focus:ring-2 focus:ring-green-500"
                      placeholder="Enter your name"
                    />
                  </div>
                </div>
              )}

              {/* Email */}
              <div>
                <label className="block text-gray-700 mb-2">Email</label>
                <div className="relative">
                  <Mail className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400 w-5 h-5" />
                  <input
                    type="email"
                    value={formData.email}
                    onChange={(e) =>
                      setFormData({ ...formData, email: e.target.value })
                    }
                    required
                    className="w-full pl-10 py-3 border rounded-lg focus:ring-2 focus:ring-green-500"
                    placeholder="Enter your email"
                  />
                </div>
              </div>

              {/* Password */}
              <div>
                <label className="block text-gray-700 mb-2">Password</label>
                <div className="relative">
                  <Lock className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400 w-5 h-5" />
                  <input
                    type="password"
                    value={formData.password}
                    onChange={(e) =>
                      setFormData({ ...formData, password: e.target.value })
                    }
                    required
                    className="w-full pl-10 py-3 border rounded-lg focus:ring-2 focus:ring-green-500"
                    placeholder="Enter your password"
                  />
                </div>
              </div>

              <button
                type="submit"
                className="w-full bg-green-600 text-white py-3 rounded-lg hover:bg-green-700"
              >
                {isLogin ? "Login" : "Register"}
              </button>
            </form>

            <p className="text-center text-gray-600 mt-6">
              {isLogin ? "Don't have an account? " : "Already have an account? "}
              <button
                onClick={() => setIsLogin(!isLogin)}
                className="text-green-600 hover:text-green-700"
              >
                {isLogin ? "Register" : "Login"}
              </button>
            </p>
          </div>
        )}
      </div>
    </div>
  );
}
