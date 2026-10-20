import { defineConfig } from "allure";

export default defineConfig({
    name: "Sauce Demo Automation",   // report title
    output: "./target/allure-report",
    historyPath: "./allure-history.jsonl",      // enables trends across runs
    plugins: {
        awesome: {
            options: {
                reportName: "Sauce Demo Automation",
                reportLanguage: "en",
                singleFile: true,                       // true = one shareable HTML file
                logo: "",                               // optional branding
                theme: "dark",                          // or "dark"
                groupBy: ["epic", "feature", "story"]   // tree grouping in the sidebar
            },
        },
    },
});