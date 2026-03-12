console.log("JavaScript berhasil terhubung!");

// ==============================
// FITUR 1: DARK MODE TOGGLE
// ==============================

const darkToggleBtn = document.querySelector('#dark-toggle');
const body = document.body;

if (darkToggleBtn) {
  darkToggleBtn.addEventListener('click', function () {

    body.classList.toggle('dark-mode');

    const isDarkMode = body.classList.contains('dark-mode');

    if (isDarkMode) {
      darkToggleBtn.textContent = '☀️ Light Mode';
    } else {
      darkToggleBtn.textContent = '🌙 Dark Mode';
    }

  });
}


// ==============================
// FITUR 2: COUNTER
// ==============================

let count = 0;

const angkaDisplay = document.querySelector('#angka-counter');
const pesanDisplay = document.querySelector('#counter-pesan');
const btnTambah = document.querySelector('#btn-tambah');
const btnKurang = document.querySelector('#btn-kurang');

function updatePesan(n) {
  if (!pesanDisplay) return;

  if (n === 0) pesanDisplay.textContent = 'My coffee is still warm buddy ☕';
  else if (n < 4) pesanDisplay.textContent = 'Is that enough for you?';
  else if (n < 8) pesanDisplay.textContent = 'Okay... my coffee is getting cold ☕';
  else pesanDisplay.textContent = 'Oh my... that is a lot 😉';
}

if (btnTambah && angkaDisplay) {
  btnTambah.addEventListener('click', function () {
    count++;
    angkaDisplay.textContent = count;
    updatePesan(count);
  });
}

if (btnKurang && angkaDisplay) {
  btnKurang.addEventListener('click', function () {
    if (count > 0) {
      count--;
      angkaDisplay.textContent = count;
      updatePesan(count);
    }
  });
}


// ==============================
// FITUR 3: VALIDASI FORM
// ==============================

const btnKirim = document.querySelector('#btn-kirim');
const inputNama = document.querySelector('#input-nama');
const inputEmail = document.querySelector('#input-email');
const inputPesan = document.querySelector('#input-pesan');
const formFeedback = document.querySelector('#form-feedback');

function tampilkanPesan(teks, tipe) {
  if (!formFeedback) return;

  formFeedback.textContent = teks;
  formFeedback.className = 'feedback ' + tipe;
}

function isEmailValid(email) {
  return email.includes('@') && email.includes('.');
}

if (btnKirim) {
  btnKirim.addEventListener('click', function () {

    const nama = inputNama.value.trim();
    const email = inputEmail.value.trim();
    const pesan = inputPesan.value.trim();

    if (nama === '' || email === '' || pesan === '') {
      tampilkanPesan('⚠️ Semua field harus diisi!', 'error');
      return;
    }

    if (!isEmailValid(email)) {
      tampilkanPesan('⚠️ Format email tidak valid! Contoh: nama@email.com', 'error');
      return;
    }

    tampilkanPesan('✅ Pesan berhasil dikirim! Terima kasih, ' + nama + '!', 'success');

    inputNama.value = '';
    inputEmail.value = '';
    inputPesan.value = '';

  });
}

