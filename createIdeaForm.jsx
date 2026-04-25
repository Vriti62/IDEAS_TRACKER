import { useState } from "react";
import api from "./api.js";

export default function CreateIdeaForm() {
    const [title, setTitle] = useState("");
    const [problemStatement, setProblemStatement] = useState("");
    const [potentialSolution, setPotentialSolution] = useState("");

    const [loading, setLoading] = useState(false);
    const [successMsg, setSuccessMsg] = useState("");
    const [errorMsg, setErrorMsg] = useState("");

    const resetMessages = () => {
        setSuccessMsg("");
        setErrorMsg("");
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        resetMessages();

        // super simple validation
        if (!title.trim() || !problemStatement.trim()) {
            setErrorMsg("Title and Problem Statement are required.");
            return;
        }

        setLoading(true);

        try {
            const payload = {
                title: title.trim(),
                problemStatement: problemStatement.trim(),
                potentialSolution: potentialSolution.trim() || null,
            };

            const res = await api.post("/ideas", payload);

            setSuccessMsg(`Idea created successfully! ID: ${res.data?.id ?? "N/A"}`);
            setTitle("");
            setProblemStatement("");
            setPotentialSolution("");
        } catch (err) {
            // show useful message
            const apiMsg =
                err?.response?.data?.message ||
                err?.response?.data?.error ||
                err?.message ||
                "Something went wrong.";
            setErrorMsg(apiMsg);
        } finally {
            setLoading(false);
        }
    };

    return (
        <div style={{ maxWidth: 640, margin: "40px auto", fontFamily: "system-ui" }}>
            <h2 style={{ marginBottom: 16 }}>Create Idea</h2>

            <form onSubmit={handleSubmit} style={{ display: "grid", gap: 12 }}>
                <label style={{ display: "grid", gap: 6 }}>
                    <span>Title *</span>
                    <input
                        value={title}
                        onChange={(e) => setTitle(e.target.value)}
                        placeholder="e.g., Automate invoice approvals"
                        style={{ padding: 10, borderRadius: 8, border: "1px solid #ccc" }}
                    />
                </label>

                <label style={{ display: "grid", gap: 6 }}>
                    <span>Problem Statement *</span>
                    <textarea
                        value={problemStatement}
                        onChange={(e) => setProblemStatement(e.target.value)}
                        placeholder="Describe the problem clearly..."
                        rows={5}
                        style={{ padding: 10, borderRadius: 8, border: "1px solid #ccc" }}
                    />
                </label>

                <label style={{ display: "grid", gap: 6 }}>
                    <span>Potential Solution (optional)</span>
                    <textarea
                        value={potentialSolution}
                        onChange={(e) => setPotentialSolution(e.target.value)}
                        placeholder="Propose a solution approach..."
                        rows={4}
                        style={{ padding: 10, borderRadius: 8, border: "1px solid #ccc" }}
                    />
                </label>

                <button
                    type="submit"
                    disabled={loading}
                    style={{
                        padding: 12,
                        borderRadius: 10,
                        border: "none",
                        background: loading ? "#888" : "#2563eb",
                        color: "white",
                        cursor: loading ? "not-allowed" : "pointer",
                        fontWeight: 600,
                    }}
                >
                    {loading ? "Submitting..." : "Submit Idea"}
                </button>

                {successMsg && (
                    <div style={{ padding: 10, borderRadius: 8, background: "#dcfce7", color: "#166534" }}>
                        {successMsg}
                    </div>
                )}

                {errorMsg && (
                    <div style={{ padding: 10, borderRadius: 8, background: "#fee2e2", color: "#991b1b" }}>
                        {errorMsg}
                    </div>
                )}
            </form>
        </div>
    );
}
