import { defineConfig } from "allure";

export default defineConfig({
    name: "Sauce Demo Automation",   // report title
    output: "./target/allure-report",
    historyPath: "./allure-history.jsonl",
    plugins: {
        awesome: {
            options: {
                reportName: "Sauce Demo Automation",
                reportLanguage: "en",
                singleFile: true,                       // true = one shareable HTML file
                logo: "",                               // optional branding
                theme: "dark",
                groupBy: ["feature", "story"]   // tree grouping in the sidebar
            },
        },
    },
});