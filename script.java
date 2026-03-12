console.log('JavaScript berhasil terhubung!');
// ==============================
// FITUR 1: DARK MODE TOGGLE
// ==============================

const darkToggleBtn = document.querySelector('#dark-toggle');
const body = document.body;

darkToggleBtn.addEventListener('click', function() {
  // Toggle class dark-mode di body
  body.classList.toggle('dark-mode');

  // Cek apakah dark mode sekarang aktif
  const isDarkMode = body.classList.contains('dark-mode');

  // Update teks tombol
  if (isDarkMode) {
    darkToggleBtn.textContent = '☀️ Light Mode';
  } else {
    darkToggleBtn.textContent = '🌙 Dark Mode';
  }
});

// ==============================
// FITUR 2: COUNTER
// ==============================

let count = 0;
const angkaDisplay = document.querySelector('#angka-counter');
const pesanDisplay = document.querySelector('#counter-pesan');
const btnTambah = document.querySelector('#btn-tambah');
const btnKurang = document.querySelector('#btn-kurang');

function updatePesan(n) {
  if (n === 0) pesanDisplay.textContent = 'my coffe still warm buddy..';
  else if (n < 4) pesanDisplay.textContent = 'its enough for you?';
  else if (n < 8) pesanDisplay.textContent = 'okay my coffe is getting cold..';
  else pesanDisplay.textContent = 'oh my..thats alot.. ;)';
}
btnTambah.addEventListener('click', function() {
  count++;
  angkaDisplay.textContent = count;
  updatePesan(count);
});

btnKurang.addEventListener('click', function() {
  if (count > 0) {
    count--;
    angkaDisplay.textContent = count;
    updatePesan(count);
  }
});

// ==============================
// FITUR 3: VALIDASI FORM
// ==============================

const btnKirim = document.querySelector('#btn-kirim');
const inputNama = document.querySelector('#input-nama');
const inputEmail = document.querySelector('#input-email');
const inputPesan = document.querySelector('#input-pesan');
const formFeedback = document.querySelector('#form-feedback');

function tampilkanPesan(teks, tipe) {
  formFeedback.textContent = teks;
  formFeedback.className = 'feedback ' + tipe; // set class
}

function isEmailValid(email) {
  // Regex sederhana untuk cek format email
  return email.includes('@') && email.includes('.');
}

btnKirim.addEventListener('click', function() {
  const nama = inputNama.value.trim();
  const email = inputEmail.value.trim();
  const pesan = inputPesan.value.trim();

  // Validasi: field kosong
  if (nama === '' || email === '' || pesan === '') {
    tampilkanPesan('⚠️ Semua field harus diisi!', 'error');
    return; // stop eksekusi di sini
  }

  // Validasi: format email
  if (!isEmailValid(email)) {
    tampilkanPesan('⚠️ Format email tidak valid! Contoh: nama@email.com', 'error');
    return;
  }

  // Jika semua valid
  tampilkanPesan('✅ Pesan berhasil dikirim! Terima kasih, ' + nama + '!', 'success');

  // Kosongkan form setelah berhasil
  inputNama.value = '';
  inputEmail.value = '';
  inputPesan.value = '';
});

