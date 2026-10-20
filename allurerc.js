import { defineConfig } from "allure";

export default defineConfig({
    name: "Sauce Demo Automation Report",
    output: "./target/allure-report",
    historyPath: "./.allure/history.jsonl",
});