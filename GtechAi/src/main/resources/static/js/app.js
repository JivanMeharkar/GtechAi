const askBtn = document.getElementById('askBtn');
const messageEl = document.getElementById('message');
const conv = document.getElementById('conversation');

askBtn.addEventListener('click', async () => {
  const msg = messageEl.value.trim();
  if (!msg) return;

  appendUser(msg);
  messageEl.value = '';

  try {
    const res = await fetch('/api/ask', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ message: msg })
    });

    if (!res.ok) {
      const txt = await res.text();
      appendAi('Server error: ' + txt);
      return;
    }

    const data = await res.json();
    appendAi(data.reply || JSON.stringify(data));
  } catch (e) {
    appendAi('Network error: ' + e.message);
  }
});

function formatText(text) {
  return text.replace(/\*\*(.*?)\*\*/g, "<b>$1</b>");
}

function appendUser(text) {
  const d = document.createElement('div');
  d.className = 'message-user';
  d.textContent = 'You: ' + text;
  conv.appendChild(d);
  window.scrollTo(0, document.body.scrollHeight);
}

function appendAi(text) {
  const d = document.createElement('div');
  d.className = 'message-ai';
  d.textContent = 'GtechAi: ' + text;
  conv.appendChild(d);
  window.scrollTo(0, document.body.scrollHeight);
}
const themeToggle = document.getElementById("themeToggle");
const body = document.body;

// Default theme
body.classList.add("light-theme");

themeToggle.addEventListener("click", () => {
  body.classList.toggle("dark-theme");
  body.classList.toggle("light-theme");

  if (body.classList.contains("dark-theme")) {
    themeToggle.textContent = "☀️ Light Mode";
    themeToggle.classList.remove("btn-outline-dark");
    themeToggle.classList.add("btn-outline-light");
  } else {
    themeToggle.textContent = "🌙 Dark Mode";
    themeToggle.classList.remove("btn-outline-light");
    themeToggle.classList.add("btn-outline-dark");
  }
});

