const PROXY_CONF = [
  {
    context: ["/api"],
    target: "http://localhost:8080/",
    secure: false, // Will be modified to use HTTPS;
    logLevel: "debug",
  },
];

module.exports = PROXY_CONF;
