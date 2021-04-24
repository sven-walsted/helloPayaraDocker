const React = require('react')
const ReactDOM = require('react-dom')

const Button = require('./stateless-button.jsx')
const SelectableText = require('./selectable-text.jsx')

const List = (props) =>
    <table id="t01">
        <thead>
            <tr>
                <th>Common Name</th>
                <th>Order</th>
                <th>Class</th>
                <th>Family</th>
                <th>Genus</th>
                <th>Species</th>
                <th><Button handleClick={props.handleAddClick} buttonLabel='Add' /></th>
            </tr>
        </thead>
        <tbody>
            {props.fishes.map((fish) => {
                return (props.activeRecordId == fish.id)
                    ?
                    <tr key={fish.id}>
                        <td>
                            <input type='text'
                                size='14'
                                name='commonName'
                                onChange={props.handleCommonChange}
                                value={props.commonName} />
                        </td>
                        <td>
                            <input type='text'
                                size='14'
                                name='className'
                                onChange={props.handleClassChange}
                                value={props.className} />
                        </td>
                        <td>
                            <input type='text'
                                size='14'
                                name='orderName'
                                onChange={props.handleOrderChange}
                                value={props.orderName} />
                        </td>
                        <td>
                            <input type='text'
                                size='14'
                                name='familyName'
                                onChange={props.handleFamilyChange}
                                value={props.familyName} />
                        </td>
                        <td>
                            <input type='text'
                                size='14'
                                name='genusName'
                                onChange={props.handleGenusChange}
                                value={props.genusName} />
                        </td>
                        <td>
                            <input type='text'
                                size='14'
                                name='speciesName'
                                onChange={props.handleSpeciesChange}
                                value={props.speciesName} />
                        </td>
                        <td>
                            <Button handleClick={props.handleCancelClick} buttonLabel='Cancel' />
                            <Button handleClick={props.handleSaveClick} buttonLabel='Save' />
                        </td>
                    </tr>
                    :
                    <tr key={fish.id}>
                        <td><span className='pointer' ><SelectableText {...props} record={fish} text={fish.commonName} /></span></td>
                        <td><span className='pointer' ><SelectableText {...props} record={fish} text={fish.className} /></span></td>
                        <td><span className='pointer' ><SelectableText {...props} record={fish} text={fish.orderName} /></span></td>
                        <td><span className='pointer' ><SelectableText {...props} record={fish} text={fish.familyName} /></span></td>
                        <td><span className='pointer' ><SelectableText {...props} record={fish} text={fish.genusName} /></span></td>
                        <td><span className='pointer' ><SelectableText {...props} record={fish} text={fish.speciesName} /></span></td>
                        <td>
                            <Button buttonLabel='Delete' handleClick={props.handleDeleteClick} recordId={fish.id} />
                        </td>
                    </tr>
            }
            )}
        </tbody>
    </table>;

module.exports = List