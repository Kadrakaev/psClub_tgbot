import React, { useState } from 'react';

function Booking() {
    const [name, setName] = useState('');
    const [phone, setPhone] = useState('');
    const [date, setDate] = useState('');
    const [message, setMessage] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();

        // простой валидация
        if (!name || !phone || !date) {
            setMessage('Пожалуйста, заполните все поля');
            return;
        }

        try {
            const response = await fetch('http://localhost:8080/api/booking', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ name, phone, date }),
            });

            if (response.ok) {
                setMessage('Бронирование успешно отправлено!');
                setName('');
                setPhone('');
                setDate('');
            } else {
                setMessage('Ошибка при отправке бронирования');
            }
        } catch (error) {
            setMessage('Ошибка сети или сервера');
        }
    };

    return (
        <div style={{ maxWidth: 400, margin: '30px auto', fontFamily: 'Arial, sans-serif' }}>
            <h2>Бронирование места</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Имя:
                    <input
                        type="text"
                        value={name}
                        onChange={e => setName(e.target.value)}
                        style={inputStyle}
                    />
                </label>
                <label>
                    Телефон:
                    <input
                        type="tel"
                        value={phone}
                        onChange={e => setPhone(e.target.value)}
                        style={inputStyle}
                    />
                </label>
                <label>
                    Дата бронирования:
                    <input
                        type="date"
                        value={date}
                        onChange={e => setDate(e.target.value)}
                        style={inputStyle}
                    />
                </label>
                <button type="submit" style={buttonStyle}>Отправить</button>
            </form>
            {message && <p style={{ marginTop: 15 }}>{message}</p>}
        </div>
    );
}

const inputStyle = {
    display: 'block',
    width: '100%',
    padding: '8px',
    margin: '8px 0 16px 0',
    boxSizing: 'border-box',
};

const buttonStyle = {
    padding: '10px 20px',
    backgroundColor: '#007bff',
    color: 'white',
    border: 'none',
    borderRadius: '6px',
    cursor: 'pointer',
};

export default Booking;
