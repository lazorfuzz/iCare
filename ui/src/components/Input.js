import styled from 'styled-components';

const Input = styled.input`
  padding: 8px 16px;
  margin: 4px 0;
  font-size: 16px;
  line-height: 1.1em;
  color: white;
  background: rgba(30, 43, 49, 0.7);
  border: 1px solid rgba(255, 255, 255, 0.3);
  border-radius: 4px;
  outline: none;
  transition: all 150ms ease-in;
  &:hover {
    background: rgba(30, 43, 49, 0.8);
  }
  &:active {
    background: rgba(30, 43, 49, 0.9);
  }
`;

const BaseInput = styled.input`
  border: none;
  color: white;
  transition: all 150ms ease-in;
  outline: none;
  font-size: 16px;
  background: transparent;
`;

const InputContainer = styled.div`
  display: flex;
  flex-flow: row;
  border-radius: 4px;
  color: white;
  border: 1px solid rgba(255, 255, 255, 0.3);
  margin: 8px 0;
  background: rgba(30, 43, 49, 0.7);
  border-radius: 4px;
  padding: 8px;
  transition: 150ms ease-in;
  &:hover {
    background: rgba(30, 43, 49, 0.8);
  }
  &:active {
    background: rgba(30, 43, 49, 0.9);
  }
  width: 450px;
  max-width: 95%;
`;

export default Input;

export { BaseInput, InputContainer };
