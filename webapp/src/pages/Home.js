import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
    return (
        <div style={{ maxWidth: 600, margin: '30px auto', fontFamily: 'Arial, sans-serif', textAlign: 'center' }}>
            <h1>PlayStation Club</h1>
            <p>Добро пожаловать в официальный WebApp нашего клуба!</p>

            <div style={{ marginTop: 40 }}>
                <Link to="/booking">
                    <button style={buttonStyle}>Забронировать место</button>
                </Link>
                <Link to="/news">
                    <button style={buttonStyle}>Новости клуба</button>
                </Link>
                <Link to="/contacts">
                    <button style={buttonStyle}>Контакты</button>
                </Link>
            </div>
        </div>
    );
}

const buttonStyle = {
    display: 'block',
    width: '80%',
    padding: '15px',
    margin: '10px auto',
    fontSize: '18px',
    cursor: 'pointer',
    borderRadius: '8px',
    backgroundColor: '#007bff',
    color: '#fff',
    border: 'none',
};

export default Home;
